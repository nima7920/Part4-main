package server.logic.util;

import server.logic.gameState.GameChar;
import server.logic.gameState.GamerMinionState;
import server.logic.gameState.PlayGroundState;
import server.models.cards.Card;
import server.models.cards.Minion;
import server.models.cards.Spell;
import server.models.cards.Weapon;
import server.models.handlers.CardFactory;

import java.util.ArrayList;
import java.util.Collections;

public class PlayGroundEditor {
    private int playerID,opponentID;
    private PlayGroundState playGroundState;
private CardFactory cardFactory;
    public PlayGroundEditor(int playerID, PlayGroundState playGroundState,CardFactory cardFactory) {
        this.playerID = playerID;
        this.playGroundState = playGroundState;
        this.cardFactory=cardFactory;
        this.opponentID=(playerID==0?1:0);
    }


    public void damageHero(int damage) {
        playGroundState.getGamer(opponentID).getGamerHero().setHp(
                playGroundState.getGamer(opponentID).getGamerHero().getHp() - damage);
    }

    public void damageToAllMinions(int damage) {
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(opponentID)[i] != null) {
                playGroundState.getGround(opponentID)[i].setHp(
                        playGroundState.getGround(opponentID)[i].getHp() - damage);
            }
        }
    }

    public void damageToAll(int damage) {
        damageToAllMinions(damage);
        damageHero(damage);
    }

    public void randomDamageToAll(int damage) {
        ArrayList<Integer> notNullIndexes = new ArrayList<>();
        // for hero
        notNullIndexes.add(-1);
// minions
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(opponentID)[i] != null) {
                notNullIndexes.add(i);
            }
        }
        for (int i = 0; i < damage; i++) {
            Collections.shuffle(notNullIndexes);
            if (notNullIndexes.get(0) == -1)
                damageHero(1);
            else
                playGroundState.getGround(opponentID)[notNullIndexes.get(i)].setHp
                        (playGroundState.getGround(opponentID)[notNullIndexes.get(i)].getHp() - damage);
        }
    }

    public void restoreHero(int hp) {
        playGroundState.getGamer(playerID).getGamerHero().setHp(
                playGroundState.getGamer(playerID).getGamerHero().getHp() + hp);
    }

    public void transformMinion(GameChar target, Minion minion) {
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(opponentID)[i]== target) {
                playGroundState.getGround(opponentID)[i] = new GamerMinionState(minion);
                break;
            }
        }

    }
    public void summonMinion(Minion minion, int number) {
        int n = number;
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(playerID)[i] == null && n > 0) {
                playGroundState.getGround(playerID)[i] = new GamerMinionState(minion);
                n--;
            }
        }

    }
    public void drawOneCard() {
        if (playGroundState.getGamer(playerID).getDeckCards().size() > 0) {
            for (int i = 0; i < 12; i++) {
                if (playGroundState.getGamer(playerID).getHandCards()[i] == null) {
                    playGroundState.getGamer(playerID).getHandCards()[i] =
                            playGroundState.getGamer(playerID).getDeckCards().get(0);
                    playGroundState.getGamer(playerID).getDeckCards().remove(0);
                    checkCurioCollector();
                    break;
                }
            }
        }
    }

    private void checkCurioCollector() {
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(playerID)[i] != null && playGroundState.getGround(playerID)[i].getName().equals("Curio Collector")) {
                playGroundState.getGround(playerID)[i].setAttack(playGroundState.getGround(playerID)[i].getAttack() + 1);
                playGroundState.getGround(playerID)[i].setHp(playGroundState.getGround(playerID)[i].getHp() + 1);
            }
        }
    }

    public void setWeapon(Weapon weapon) {
        playGroundState.getGamer(playerID).getGamerHero().setGamerWeapon(weapon);
    }

    public void addCardToHand(String cardName) {
        Card card = cardFactory.getCard(cardName);
        for (int i = 0; i < 12; i++) {
            if (playGroundState.getGamer(playerID).getHandCards()[i] == null) {
                playGroundState.getGamer(playerID).getHandCards()[i] = card;
                break;
            }
        }
    }
    public void addCardToDeck(String cardName) {
        Card card = cardFactory.getCard(cardName);
        playGroundState.getGamer(playerID).getDeckCards().add(card);
    }

    public void addMinionToGround(String name) {
        Minion minion = (Minion) cardFactory.getCard(name);
        for (int i = 0; i < 7; i++) {
            if (playGroundState.getGround(playerID)[i] == null) {
                playGroundState.getGround(playerID)[i] = new GamerMinionState(minion);
                break;
            }

        }
    }

    //this is for book of specters action
    public void drawIfNotSpell(int number) {
        for (int i = 0; i < number; i++) {
            if (playGroundState.getGamer(playerID).getDeckCards().size() > 0) {
                if (!(playGroundState.getGamer(playerID).getDeckCards().get(0) instanceof Spell)) {
                    drawOneCard();
                } else {
                    playGroundState.getGamer(playerID).getDeckCards().remove(0);
                }
            } else
                break;
        }
    }
    // methods for discover
    public void addDiscover(String[] cardNames) {
        playGroundState.getGamer(playerID).setDiscoveredCards(cardNames);
        playGroundState.getGamer(playerID).setDiscoverMode(true);
    }

    public void selectDiscover(String cardName) {
        playGroundState.getGamer(playerID).setDiscoverMode(false);
        Weapon discoverCard = ((Weapon) cardFactory.getCard(cardName));
        discoverCard.setAttack(discoverCard.getAttack() + 2);
        discoverCard.setDurability(discoverCard.getDurability() + 2);
        playGroundState.getGamer(playerID).getDeckCards().add(discoverCard);
        playGroundState.getGamer(playerID).setDiscoveredCards(null);
    }
}

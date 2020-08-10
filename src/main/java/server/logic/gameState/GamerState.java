package server.logic.gameState;

import server.models.cards.Card;

import java.util.ArrayList;

public class GamerState {

    private int mana = 1, turnNumber = 1;
    private GamerHeroState gamerHero = null;
    private GamerHeroPowerState gamerHeroPower = null;
    private ArrayList<Card> deckCards;
    private Card[] handCards;

    public GamerState(){

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public GamerHeroState getGamerHero() {
        return gamerHero;
    }

    public void setGamerHero(GamerHeroState gamerHero) {
        this.gamerHero = gamerHero;

    }

    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(ArrayList<Card> deckCards) {
        this.deckCards = deckCards;
    }

    public Card[] getHandCards() {
        return handCards;
    }

    public void setHandCards(Card[] handCards) {
        this.handCards = handCards;
    }

    public GamerHeroPowerState getGamerHeroPower() {
        return gamerHeroPower;
    }

    public void setGamerHeroPower(GamerHeroPowerState gamerHeroPower) {
        this.gamerHeroPower = gamerHeroPower;
    }

    public void refresh() {
        mana = 1;
        turnNumber = 1;
        gamerHero = null;
        gamerHeroPower = null;
        deckCards = new ArrayList<>();
        handCards = new Card[12];
    }
}

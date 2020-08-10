package server.logic.visitors;

import server.logic.gameState.GameChar;
import server.logic.gameState.GamerMinionState;
import server.logic.util.PlayGroundEditor;
import server.models.allCards.CustomMinion;
import server.models.heroes.*;

import java.util.Random;

public class PowerActionVisitor implements HeroPowerVisitor{
    private Random random = new Random();
private PlayGroundEditor playGroundEditor;

    public PowerActionVisitor(PlayGroundEditor playGroundEditor) {
        this.playGroundEditor = playGroundEditor;
    }

    @Override
    public void mageVisit(Mage mage, GameChar target) {
        target.setHp(target.getHp() - 1);
    }

    @Override
    public void rogueVisit(Rogue rogue, GameChar target) {
        playGroundEditor.stealCardFromDeck();
        if (playGroundEditor.heroHasWeapon()) {
            playGroundEditor.stealCardFromHand();
        }
    }

    @Override
    public void warlockVisit(Warlock warlock, GameChar target) {
        playGroundEditor.restoreHero(-2);
        boolean decision = random.nextBoolean();
        if (decision) {
            playGroundEditor.drawOneCard();
        } else {
            GamerMinionState randomMinion = playGroundEditor.getRandomMinionFromHand();
            if (randomMinion != null) {
                randomMinion.setAttack(randomMinion.getAttack() + 1);
                randomMinion.setHp(randomMinion.getHp() + 1);
            }
        }
    }

    @Override
    public void hunterVisit(Hunter hunter, GameChar target) {

    }

    @Override
    public void paladinVisit(Paladin paladin, GameChar target) {
        playGroundEditor.summonMinion(new CustomMinion(1, 1), 2);
    }
}

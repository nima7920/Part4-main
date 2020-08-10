package server.logic.visitors;

import server.logic.util.PlayGroundEditor;
import server.models.passives.*;

public class DeathRattleVisitor implements PassiveVisitor {
    private PlayGroundEditor playGroundEditor;

    public DeathRattleVisitor(PlayGroundEditor playGroundEditor) {
        this.playGroundEditor = playGroundEditor;
    }

    @Override
    public void twiceDrawVisit(TwiceDraw twiceDraw) {

    }

    @Override
    public void manaJumpVisit(ManaJump manaJump) {

    }

    @Override
    public void offCardsVisit(OffCards offCards) {

    }

    @Override
    public void freePowerVisit(FreePower freePower) {

    }

    @Override
    public void warriorsVisit(Warriors warriors) {
        playGroundEditor.restoreHero(1);
    }
}

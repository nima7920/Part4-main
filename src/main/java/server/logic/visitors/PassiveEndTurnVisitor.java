package server.logic.visitors;

import server.logic.util.PlayGroundEditor;
import server.models.passives.*;

public class PassiveEndTurnVisitor implements PassiveVisitor{
    private PlayGroundEditor playGroundEditor;

    public PassiveEndTurnVisitor(PlayGroundEditor playGroundEditor) {
        this.playGroundEditor = playGroundEditor;
    }

    @Override
    public void twiceDrawVisit(TwiceDraw twiceDraw) {
playGroundEditor.drawOneCard();
    }

    @Override
    public void manaJumpVisit(ManaJump manaJump) {
playGroundEditor.addMana();
    }

    @Override
    public void offCardsVisit(OffCards offCards) {

    }

    @Override
    public void freePowerVisit(FreePower freePower) {

    }

    @Override
    public void warriorsVisit(Warriors warriors) {

    }
}

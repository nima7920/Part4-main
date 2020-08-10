package server.logic.visitors;

import server.models.passives.*;

public interface PassiveVisitor {
    void twiceDrawVisit(TwiceDraw twiceDraw);
    void manaJumpVisit(ManaJump manaJump);
    void offCardsVisit(OffCards offCards);
    void freePowerVisit(FreePower freePower);
    void warriorsVisit(Warriors warriors);
}

package server.models.passives;

import server.logic.visitors.PassiveVisitor;

public class ManaJump extends Passive {
    public ManaJump(){
        setPassiveName("Mana Jump");
        setPassiveText("Earn +1 mana each turn");
    }

    @Override
    public void accept(PassiveVisitor passiveVisitor) {
        passiveVisitor.manaJumpVisit(this);
    }
}

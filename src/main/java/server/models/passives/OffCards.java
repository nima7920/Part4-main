package server.models.passives;

import server.logic.visitors.PassiveVisitor;

public class OffCards extends Passive {

    public OffCards(){
        setPassiveName("Off Cards");
        setPassiveText("Spend -1 mana for each card");
    }

    @Override
    public void accept(PassiveVisitor passiveVisitor) {
        passiveVisitor.offCardsVisit(this);
    }
}

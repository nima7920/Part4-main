package server.models.passives;

import server.logic.visitors.PassiveVisitor;

public class FreePower extends Passive{
    public FreePower(){
        setPassiveName("Free Power");
        setPassiveText("Hero power costs -1 mana,Use hero power twice a tur");
    }

    @Override
    public void accept(PassiveVisitor passiveVisitor) {
        passiveVisitor.freePowerVisit(this);
    }
}

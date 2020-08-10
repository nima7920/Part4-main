package server.models.passives;

import server.logic.visitors.PassiveVisitor;

public class TwiceDraw extends Passive{
    public TwiceDraw(){
        setPassiveName("Twice Draw");
        setPassiveText("Draw 2 cards each turn");
    }

    @Override
    public void accept(PassiveVisitor passiveVisitor) {
        passiveVisitor.twiceDrawVisit(this);
    }
}

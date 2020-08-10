package server.models.passives;

import server.logic.visitors.PassiveVisitor;

public abstract class Passive {
    protected String passiveName,passiveText;

    public abstract void accept(PassiveVisitor passiveVisitor);

    public String getPassiveName() {
        return passiveName;
    }

    public void setPassiveName(String passiveName) {
        this.passiveName = passiveName;
    }

    public String getPassiveText() {
        return passiveText;
    }

    public void setPassiveText(String passiveText) {
        this.passiveText = passiveText;
    }
}

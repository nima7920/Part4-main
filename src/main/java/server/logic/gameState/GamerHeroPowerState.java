package server.logic.gameState;

import server.models.heroes.HeroPower;

public class GamerHeroPowerState {

    private HeroPower heroPower;
    private String heroName;
    private boolean enabled=true;
    private int targetType=0;
    private int manaCost=0;

    public GamerHeroPowerState(HeroPower heroPower){
        this.heroPower=heroPower;
        this.heroName=heroPower.getHeroClass().toString();
        this.manaCost=heroPower.getManaCost();
        this.targetType=heroPower.getTargetType();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getTargetType() {
        return targetType;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getHeroName() {
        return heroName;
    }
}

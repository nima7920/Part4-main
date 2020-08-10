package client_server_interfaces.playGround;

import com.google.gson.annotations.Expose;

public class GamerHeroPower {
   @Expose
    private String heroName;
    @Expose
    private boolean enabled=true;
    @Expose
    private int targetType=0;
    @Expose
    private int manaCost=0;

    public GamerHeroPower() {
    }

    public GamerHeroPower(String heroName, boolean enabled, int targetType, int manaCost) {
        this.heroName = heroName;
        this.enabled = enabled;
        this.targetType = targetType;
        this.manaCost = manaCost;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}

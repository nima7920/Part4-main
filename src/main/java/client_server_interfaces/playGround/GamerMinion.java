package client_server_interfaces.playGround;

import com.google.gson.annotations.Expose;

public class GamerMinion {

    @Expose
    private int attack;
    @Expose
    private int hp;
    @Expose
    private String name;
    @Expose
    private boolean enabled = false;
    @Expose
    private boolean inRush = false;
    @Expose
    private boolean inCharge = false;
    @Expose
    private boolean isTaunt = false;
    @Expose
    private boolean hasDivineShield = false;
    @Expose
    private boolean isLifeSteal = false;
    @Expose
    private boolean isPoisonous = false;
    @Expose
    private boolean isWindFury = false;


    public GamerMinion(){

    }

    public GamerMinion(int attack, int hp, String name) {
        this.attack = attack;
        this.hp = hp;
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isInRush() {
        return inRush;
    }

    public void setInRush(boolean inRush) {
        this.inRush = inRush;
    }

    public boolean isInCharge() {
        return inCharge;
    }

    public void setInCharge(boolean inCharge) {
        this.inCharge = inCharge;
    }

    public boolean isTaunt() {
        return isTaunt;
    }

    public void setTaunt(boolean taunt) {
        isTaunt = taunt;
    }

    public boolean isHasDivineShield() {
        return hasDivineShield;
    }

    public void setHasDivineShield(boolean hasDivineShield) {
        this.hasDivineShield = hasDivineShield;
    }

    public boolean isLifeSteal() {
        return isLifeSteal;
    }

    public void setLifeSteal(boolean lifeSteal) {
        isLifeSteal = lifeSteal;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }

    public boolean isWindFury() {
        return isWindFury;
    }

    public void setWindFury(boolean windFury) {
        isWindFury = windFury;
    }
}

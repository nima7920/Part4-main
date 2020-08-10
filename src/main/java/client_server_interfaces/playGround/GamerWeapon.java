package client_server_interfaces.playGround;

import com.google.gson.annotations.Expose;

public class GamerWeapon {
    @Expose
    private String name;
    @Expose
    private int durability, attack;
    @Expose
    private boolean enabled;

    public GamerWeapon(){

    }

    public GamerWeapon(String name, int durability, int attack, boolean enabled) {
        this.name = name;
        this.durability = durability;
        this.attack = attack;
        this.enabled = enabled;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

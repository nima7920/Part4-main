package client_server_interfaces.playGround;

import com.google.gson.annotations.Expose;

public class GamerHero {
    @Expose
    private int hp;
    @Expose
    private String name;
    @Expose
    private GamerWeapon gamerWeapon;

    public GamerHero(){

    }

    public GamerHero(int hp, String name, GamerWeapon gamerWeapon) {
        this.hp = hp;
        this.name = name;
        this.gamerWeapon = gamerWeapon;
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

    public GamerWeapon getGamerWeapon() {
        return gamerWeapon;
    }

    public void setGamerWeapon(GamerWeapon gamerWeapon) {
        this.gamerWeapon = gamerWeapon;
    }
}

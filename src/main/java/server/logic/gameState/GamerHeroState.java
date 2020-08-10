package server.logic.gameState;

import server.models.cards.Weapon;
import server.models.heroes.Hero;

public class GamerHeroState extends GameChar{
    private Hero hero;
    private GamerWeaponState gamerWeapon;

    public GamerHeroState(Hero hero) {
        this.hero = hero;
        this.hp = hero.getHp();
        this.name = hero.toString();
        this.gamerWeapon = null;
    }

    public GamerWeaponState getGamerWeapon() {
        return gamerWeapon;
    }

    public void setGamerWeapon(Weapon weapon) {
        if (weapon == null)
            this.gamerWeapon = null;
        else
            this.gamerWeapon = new GamerWeaponState(weapon);
    }

    public Hero getHero() {
        return hero;
    }
}

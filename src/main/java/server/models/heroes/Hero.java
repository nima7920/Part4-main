package server.models.heroes;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import server.logic.gameState.GameChar;
import server.logic.visitors.HeroPowerVisitor;

import javax.persistence.*;

@Entity
public abstract class Hero {

    @Column
    private int hp;
    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private HeroPower heroPower;
    @Id
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;

    public Hero() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }


    public static Hero getHeroFromName(String heroName) {
        switch (heroName) {
            case "Mage": {
                return new Mage();

            }
            case "Rogue": {
                return new Rogue();

            }
            case "Warlock": {
                return new Warlock();

            }
            case "Paladin": {
                return new Paladin();

            }
            case "Hunter": {
                return new Hunter();

            }
            default: {
                return new Mage();

            }
        }
    }

    public abstract void accept(HeroPowerVisitor heroPowerVisitor, GameChar target);

    @Override
    public String toString() {
        return heroClass.toString();
    }
}

package server.models.heroes;

import server.logic.interfaces.GameChar;
import server.logic.visitors.HeroPowerVisitor;

import javax.persistence.Entity;

@Entity
public class Mage extends Hero {
    public Mage() {
        setHeroClass(HeroClass.Mage);
        setHp(30);
        setHeroPower(new HeroPower(HeroClass.Mage,2,2));

    }

    @Override
    public void accept(HeroPowerVisitor heroPowerVisitor, GameChar target) {
        heroPowerVisitor.mageVisit(this,target);
    }
}

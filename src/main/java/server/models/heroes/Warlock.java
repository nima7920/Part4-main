package server.models.heroes;

import server.logic.interfaces.GameChar;
import server.logic.visitors.HeroPowerVisitor;

import javax.persistence.Entity;

@Entity
public class Warlock extends Hero {
    public Warlock() {
        setHeroClass(HeroClass.Warlock);
        setHp(35);
        setHeroPower(new HeroPower(HeroClass.Warlock,1,2));
    }

    @Override
    public void accept(HeroPowerVisitor heroPowerVisitor, GameChar target) {
        heroPowerVisitor.warlockVisit(this,target);
    }
}

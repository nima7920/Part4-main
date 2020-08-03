package server.models.heroes;

import server.logic.interfaces.GameChar;
import server.logic.visitors.HeroPowerVisitor;

import javax.persistence.Entity;

@Entity
public class Paladin extends Hero {
    public Paladin() {
        setHeroClass(HeroClass.Paladin);
        setHp(30);
        setHeroPower(new HeroPower(HeroClass.Paladin,1,2));
    }

    @Override
    public void accept(HeroPowerVisitor heroPowerVisitor, GameChar target) {
        heroPowerVisitor.paladinVisit(this,target);
    }
}

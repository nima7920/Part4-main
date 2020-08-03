package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class HeavyAxe extends Weapon {
    public HeavyAxe() {
    }

    public HeavyAxe(String cardName, String cardDescription, Rarity rarity, CardClass cardClass, int gemCost, int manaCost, int attack, int durability) {
        super(cardName,cardDescription,rarity,cardClass,gemCost,manaCost,attack,durability);
    }

    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.heavyAxeVisit(this,target);
    }
}

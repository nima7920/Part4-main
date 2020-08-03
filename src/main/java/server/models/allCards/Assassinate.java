package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class Assassinate extends Spell {
    public Assassinate() {
    }

    public Assassinate(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription);
        this.targetType=2;
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.assassinateVisit(this,target);
    }

}

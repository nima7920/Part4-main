package server.models.allCards;

import server.models.cards.*;
import server.logic.gameState.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class IronFist extends Spell {
    public IronFist() {
    }

    public IronFist(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription);
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.ironFistVisit(this,target);
    }

}

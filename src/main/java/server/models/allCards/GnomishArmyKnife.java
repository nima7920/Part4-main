package server.models.allCards;

import server.models.cards.*;
import server.logic.gameState.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class GnomishArmyKnife extends Spell {
    public GnomishArmyKnife() {
    }

    public GnomishArmyKnife(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription);
        this.targetType=1;
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.gnomishArmyKnifeVisit(this,target);
    }

}

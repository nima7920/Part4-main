package server.models.allCards;

import server.models.cards.*;
import server.logic.gameState.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class WickedKnife extends Weapon {
    public WickedKnife() {
    }

    public WickedKnife(String cardName, String cardDescription, Rarity rarity, CardClass cardClass, int gemCost, int manaCost, int attack, int durability) {
        super(cardName,cardDescription,rarity,cardClass,gemCost,manaCost,attack,durability);
    }

    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.wickedKnifeVisit(this,target);
    }
}

package server.models.allCards;

import server.models.cards.*;
import server.logic.gameState.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class Fireball extends Spell {
    public Fireball() {
    }

    public Fireball(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription);
        this.targetType=3;
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.fireballVisit(this,target);
    }

}

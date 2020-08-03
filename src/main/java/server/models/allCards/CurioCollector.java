package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class CurioCollector extends Minion {
    public CurioCollector() {
    }

    public CurioCollector(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription, int attack, int hp) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription,attack,hp);

    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.curioCollectorVisit(this,target);
    }
}

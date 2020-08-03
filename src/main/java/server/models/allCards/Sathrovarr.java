package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class Sathrovarr extends Minion {
    public Sathrovarr() {
    }

    public Sathrovarr(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription, int attack, int hp) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription,attack,hp);
        this.targetType=1;
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.sathrovarrVisit(this,target);
    }
}

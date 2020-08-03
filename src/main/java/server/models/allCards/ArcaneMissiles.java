package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;

import javax.persistence.Entity;

@Entity
public class ArcaneMissiles extends Spell {

    public ArcaneMissiles(){

    }
    public ArcaneMissiles(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription) {
      super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription);
    }

    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.arcaneMissilesVisit(this,target);
    }
}

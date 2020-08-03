package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;
import javax.persistence.Entity;

@Entity
public class BloodFury extends Weapon {
    public BloodFury() {
    }

    public BloodFury(String cardName, String cardDescription, Rarity rarity, CardClass cardClass, int gemCost, int manaCost, int attack, int durability) {
     super(cardName,cardDescription,rarity,cardClass,gemCost,manaCost,attack,durability);
    }

    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.bloodFuryVisit(this,target);
    }
}
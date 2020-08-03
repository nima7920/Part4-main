package server.models.allCards;

import server.models.cards.*;
import server.logic.interfaces.GameChar;
import server.logic.visitors.CardVisitor;


public class CustomMinion extends Minion {

public CustomMinion(int attack,int hp){
    this.attack=attack;
    this.hp=hp;
    this.cardName="Custom Minion";
}

    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
       cardVisitor.customMinionVisit(this,target);
    }
}

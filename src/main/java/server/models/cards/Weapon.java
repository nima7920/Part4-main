package server.models.cards;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Weapon extends Card {

    @Column
    protected int durability;
    @Column
    protected int attack;

    public Weapon() {
    }


    public Weapon(String cardName, String cardDescription, Rarity rarity, CardClass cardClass, int gemCost, int manaCost,int attack,int durability) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.rarity = rarity;
        this.cardClass = cardClass;
        this.gemCost = gemCost;
        this.manaCost = manaCost;
        this.attack=attack;
        this.durability=durability;
    }
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

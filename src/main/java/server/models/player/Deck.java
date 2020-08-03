package server.models.player;

import server.models.cards.Card;
import server.models.heroes.HeroClass;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.ArrayList;

public class Deck {

    @Id
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;
    private ArrayList<Card> cards;
    @Column
    private ArrayList<String> cardsName;

    public Deck(){

    }

    public Deck(String name, HeroClass heroClass) {
        this.heroClass = heroClass;
        this.name = name;
        cards = new ArrayList<>();
        cardsName = new ArrayList<>();
    }

    public int addCard(String cardName) {
//        if (cardFactory == null)
//            cardFactory = new CardFactory();
//        Card card = cardFactory.getCard(cardName);
//        if (!(card.getCardClass().toString().equals(heroClass.toString()) || card.getCardClass().toString().equals("Neutral"))) {
//            // card is in illegal class
//            return -1;
//        } else if (cardsName.indexOf(cardName) != cardsName.lastIndexOf(cardName)) {
//// there are two cards of this in deck
//            return 0;
//        }
//        if (cardsName.size() == 30) // deck is full
//            return -2;
//
//        cardsName.add(cardName);
//        syncCards();
//        return 1;
        return 0;
    }

    public void removeCard(String cardName) {
        cardsName.remove(cardName);
        syncCards();
    }

    public void syncCards() {
//        cards = new ArrayList<>();
//        if (cardFactory == null)
//            cardFactory = new CardFactory();
//        for (int i = 0; i < cardsName.size(); i++) {
//            cards.add(cardFactory.getCard(cardsName.get(i)));
//        }
    }
    public Deck getClone(){
        Deck tempDeck=new Deck(this.name,this.heroClass);
        for (int i = 0; i <this.getCardsName().size() ; i++) {
            tempDeck.addCard(this.cardsName.get(i));
        }
        return tempDeck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<String> getCardsName() {
        return cardsName;
    }

    public void setCardsName(ArrayList<String> cardsName) {
        this.cardsName = cardsName;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

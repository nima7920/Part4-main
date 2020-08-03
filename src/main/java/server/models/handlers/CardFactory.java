package server.models.handlers;

import server.models.cards.Card;
import server.models.cards.CardClass;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

private DataBaseHandler dataBaseHandler;

public CardFactory(){
    dataBaseHandler =new DataBaseHandler();
}
    public Card getCard(String cardName) {

        return dataBaseHandler.fetch(Card.class, cardName);
    }

    public List<Card> getAllCards() {

        return dataBaseHandler.fetchAll(Card.class);
    }

    public List<String> getAllCardsName() {
        List<String> names = new ArrayList<>();
        List<Card> cards = getAllCards();
        for (int i = 0; i < cards.size(); i++) {
            names.add(cards.get(i).getCardName());
        }
        return names;
    }

    public List<Card> getCardsOfClass(CardClass cardClass) {
        return dataBaseHandler.fetchWithCondition(Card.class, "cardClass", cardClass);
    }

    public List<String> getCardsNameOfClass(String cardClass) {
        List<String> names = new ArrayList<>();
        List<Card> cards = getCardsOfClass(CardClass.valueOf(cardClass));
        for (int i = 0; i < cards.size(); i++) {
            names.add(cards.get(i).getCardName());
        }
        return names;
    }

    public List<Card> getCardsOfMana(int mana) {
        return dataBaseHandler.fetchWithCondition(Card.class, "manaCost", mana);

    }

    public List<String> getCardsNameOfMana(int mana) {
        List<String> names = new ArrayList<>();
        List<Card> cards = getCardsOfMana(mana);
        for (int i = 0; i < cards.size(); i++) {
            names.add(cards.get(i).getCardName());
        }
        return names;
    }

    public ArrayList<Card> getCardListFromNames(ArrayList<String> cardNames){
        ArrayList<Card> cards=new ArrayList<>();
        for (int i = 0; i <cardNames.size() ; i++) {
            cards.add(getCard(cardNames.get(i)));
        }
        return cards;
    }
}

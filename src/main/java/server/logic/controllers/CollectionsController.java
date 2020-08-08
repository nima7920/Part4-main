package server.logic.controllers;

import server.logic.engine.ResponseHandler;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectionsController extends Controller {

    // fields to be saved
    private ArrayList<String> allCardsNames=new ArrayList<>();
    private ArrayList<String> deckCardsNames=new ArrayList<>();
    private String selectedDeckName="";
    private String deckPanelSelectedCard="";
    private String addPanelSelectedCard="";

    public CollectionsController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory) {
        super(responseHandler, playerHandler, cardFactory);
    }

    public void sendAllCards(HashMap<String, String> parameters){

    }

    public void gotoDeckPanel(){


    }

    public void selectDeck(HashMap<String, String> parameters){

    }
    public void deckDeleteCard(){

    }

    private List<String> getCardsWithConditions(String cardClass, boolean owned, int mana, String searchTerm) {
        List<String> cards = new ArrayList<>(), temp = new ArrayList<>();
        if (cardClass.equals("All")) {
            if (owned) {
                cards = (ArrayList) playerHandler.getOwnedCardsName().clone();
            } else {
                temp = cardFactory.getAllCardsName();
                for (int i = 0; i < temp.size(); i++) {
                    if (!playerHandler.getOwnedCardsName().contains(temp.get(i)))
                        cards.add(temp.get(i));
                }
            }

        } else {
            temp = cardFactory.getCardsNameOfClass(cardClass);
            if (owned) {
                for (int i = 0; i < temp.size(); i++) {
                    if (playerHandler.getOwnedCardsName().contains(temp.get(i)))
                        cards.add(temp.get(i));
                }
            } else {
                for (int i = 0; i < temp.size(); i++) {
                    if (!playerHandler.getOwnedCardsName().contains(temp.get(i)))
                        cards.add(temp.get(i));
                }
            }

        }
        List<String> temp2 = cards;
        if (mana != 0) {
            temp = cardFactory.getCardsNameOfMana(mana);
            temp2 = new ArrayList<>();
            for (int i = 0; i < cards.size(); i++) {
                if (temp.contains(cards.get(i)))
                    temp2.add(cards.get(i));
            }
        }
        temp = search(temp2, searchTerm);
        return temp;
    }

    private List<String> search(List<String> list, String searchTerm) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().startsWith(searchTerm.toLowerCase()))
                temp.add(list.get(i));
        }
        return temp;
    }

   private ArrayList<String> getAddableCards(String deckName) {
        ArrayList<String> cardNames = new ArrayList<>();
        ArrayList<String> deckCards = (ArrayList)((ArrayList) playerHandler.getDeckFromName(deckName).getCardsName()).clone();
        ArrayList<String> neutralCards = (ArrayList) cardFactory.getCardsNameOfClass("Neutral");
        String deckHero = playerHandler.getDeckFromName(deckName).getHeroClass().toString();
        ArrayList<String> deckHeroCards = (ArrayList) cardFactory.getCardsNameOfClass(deckHero);
        ArrayList<String> playerCards=(ArrayList) playerHandler.getOwnedCardsName().clone();
        for (int i = 0; i < neutralCards.size(); i++) {
            if (deckCards.indexOf(neutralCards.get(i)) == deckCards.lastIndexOf(neutralCards.get(i)) && deckCards.indexOf(neutralCards.get(i)) == -1) {
                cardNames.add(neutralCards.get(i));
            }
            if (deckCards.indexOf(neutralCards.get(i)) == deckCards.lastIndexOf(neutralCards.get(i))) {
                cardNames.add(neutralCards.get(i));
            }
        }
        for (int i = 0; i < deckHeroCards.size(); i++) {
            if (deckCards.indexOf(deckHeroCards.get(i)) == deckCards.lastIndexOf(deckHeroCards.get(i)) && deckCards.indexOf(deckHeroCards.get(i)) == -1) {
                cardNames.add(deckHeroCards.get(i));
            }
            if (deckCards.indexOf(deckHeroCards.get(i)) == deckCards.lastIndexOf(deckHeroCards.get(i))) {
                cardNames.add(deckHeroCards.get(i));
            }
        }
        ArrayList<String> cardNames2=new ArrayList<>();
        for (int i = 0; i <cardNames.size() ; i++) {
            if(playerCards.contains(cardNames.get(i))){
                cardNames2.add(cardNames.get(i));
            }
        }
        return cardNames2;
    }
}

package server.logic.controllers;

import server.logic.engine.ResponseHandler;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreController extends Controller{

    public StoreController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory) {
        super(responseHandler, playerHandler, cardFactory);
    }

    public void sendBuyableCards(){

    }

    public void sendSalableCards(){


    }

    public void selectCard(HashMap<String, String> parameters){

    }

    public void buyCard(HashMap<String, String> parameters){

    }

    public void sellCard(HashMap<String, String> parameters){


    }
    private List<String> getBuyableCards() {
        ArrayList<String> buyableCard = (ArrayList) allCardsName.clone();
        for (String x : playerHandler.getOwnedCardsName()) {
            buyableCard.remove(x);
        }
        return buyableCard;
    }

    private List<String> getSalableCards() {
        List<String> salableCards = (List) playerHandler.getOwnedCardsName().clone();
        return salableCards;
    }
}

package server.logic.controllers;

import client_server_interfaces.RequestType;
import client_server_interfaces.Response;
import server.logic.engine.ResponseHandler;
import server.models.cards.Card;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreController extends Controller {

    public StoreController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory) {
        super(responseHandler, playerHandler, cardFactory);
    }

    public void sendBuyableCards() {
        Response response = new Response();
        response.setRequestType(RequestType.store_buyPanel);
        response.setNamesList((ArrayList) getBuyableCards());
        responseHandler.handleResponse(response);
    }

    public void sendSalableCards() {
        Response response = new Response();
        response.setRequestType(RequestType.store_sellPanel);
        response.setNamesList((ArrayList) getSalableCards());
        responseHandler.handleResponse(response);
    }

    public void selectCard(HashMap<String, String> parameters) {
        Card card = cardFactory.getCard(parameters.get("cardName"));
        int wallet = playerHandler.getGems();
        Response response = new Response();
        response.setRequestType(RequestType.store_cardSelect);
        HashMap<String, String> resParameters = new HashMap<>();
        resParameters.put("wallet", wallet + "");
        resParameters.put("cost", card.getGemCost() + "");
        resParameters.put("cardClass", card.getCardClass().toString());
        resParameters.put("rarity", card.getRarity().toString());
        response.setParameters(resParameters);
        responseHandler.handleResponse(response);
    }

    public void buyCard(HashMap<String, String> parameters) {
        Response response = new Response();
        response.setRequestType(RequestType.store_buyCard);
        Card card = cardFactory.getCard(parameters.get("cardName"));
        if (playerHandler.getGems() < card.getGemCost()) {
            response.setResultCode(0);
            HashMap<String, String> resParameters = new HashMap<>();
            resParameters.put("wallet", playerHandler.getGems() + "");
            resParameters.put("cost", card.getGemCost() + "");
            resParameters.put("cardClass", card.getCardClass().toString());
            resParameters.put("rarity", card.getRarity().toString());
            response.setParameters(resParameters);
        } else {
            response.setResultCode(1);
            playerHandler.addCard(card.getCardName());
            playerHandler.setGems(playerHandler.getGems() - card.getGemCost());
            HashMap<String, String> resParameters = new HashMap<>();
            resParameters.put("wallet", playerHandler.getGems() + "");
            resParameters.put("cost", "");
            resParameters.put("cardClass", "");
            resParameters.put("rarity", "");
            response.setParameters(resParameters);
        }
        response.setNamesList((ArrayList) getBuyableCards());
        responseHandler.handleResponse(response);
    }

    public void sellCard(HashMap<String, String> parameters) {
        Response response = new Response();
        response.setRequestType(RequestType.store_buyCard);
        Card card = cardFactory.getCard(parameters.get("cardName"));
        playerHandler.deleteCard(card.getCardName());
        playerHandler.setGems(playerHandler.getGems() + card.getGemCost());
        HashMap<String, String> resParameters = new HashMap<>();
        resParameters.put("wallet", playerHandler.getGems() + "");
        resParameters.put("cost", "");
        resParameters.put("cardClass", "");
        resParameters.put("rarity", "");
        response.setNamesList((ArrayList) getSalableCards());
        response.setParameters(resParameters);
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

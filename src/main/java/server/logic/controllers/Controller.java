package server.logic.controllers;

import server.logic.engine.ResponseHandler;
import server.models.cards.Card;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.ArrayList;

public abstract class Controller {

    protected PlayerHandler playerHandler;
    protected ResponseHandler responseHandler;
    protected ArrayList<Card> allCards;
    protected ArrayList<String> allCardsName;
    protected CardFactory cardFactory;

    public Controller(){

    }

    public Controller(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory) {
        this.responseHandler = responseHandler;
        this.playerHandler = playerHandler;
        this.cardFactory = cardFactory;
        initAllCards();
    }

    private void initAllCards() {
        allCards = (ArrayList) cardFactory.getAllCards();
        allCardsName = (ArrayList) cardFactory.getAllCardsName();
    }
}

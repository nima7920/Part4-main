package server.logic.engine;

import server.logic.controllers.LoginController;
import server.logic.controllers.MainController;
import server.logic.controllers.StoreController;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.HashMap;

public class Engine {

    private ResponseHandler responseHandler;

    // model handlers for controllers
    private PlayerHandler playerHandler;
    private CardFactory cardFactory;

    // controller objects
    private LoginController loginController;
    private MainController mainController;
    private StoreController storeController;

    public Engine(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        playerHandler = new PlayerHandler();
        cardFactory = new CardFactory();
        initControllers();
    }

    private void initControllers() {
        loginController = new LoginController(responseHandler, playerHandler, cardFactory);
        mainController = new MainController(responseHandler, playerHandler, cardFactory);
        storeController = new StoreController(responseHandler, playerHandler, cardFactory);

    }

    // login menu methods
    public void login(HashMap<String, String> parameters) {
        loginController.login(parameters);
    }

    public void signUp(HashMap<String, String> parameters) {
        loginController.sign_up(parameters);
    }

    public void deleteAccount(HashMap<String, String> parameters) {
        loginController.delete(parameters);
    }

    public void exitGame() {

    }

    public void backToMain() {

    }

    public void sendBuyableCards() {
        storeController.sendBuyableCards();
    }

    public void sendSalableCards() {
        storeController.sendSalableCards();
    }

    public void selectCardForBuySell(HashMap<String, String> parameters) {
        storeController.selectCard(parameters);
    }

    public void buyCard(HashMap<String, String> parameters) {
        storeController.buyCard(parameters);
    }

    public void sellCard(HashMap<String, String> parameters) {
        storeController.sellCard(parameters);
    }
}

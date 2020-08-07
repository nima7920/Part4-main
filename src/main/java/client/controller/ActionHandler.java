package client.controller;

import client.gui.GameScreen;
import client.gui.login.LoginActions;
import client.gui.main.MainActions;
import client.gui.store.StoreActions;
import client_server_interfaces.Response;

public class ActionHandler {

    private GameScreen gameScreen;
    // actions classes
    private LoginActions loginActions;
    private MainActions mainActions;
    private StoreActions storeActions;

    public ActionHandler() {
        gameScreen = GameScreen.getInstance();
        initActions();
    }

    private void initActions() {
        loginActions = (LoginActions) gameScreen.getMenuActions("login");
        mainActions = (MainActions) gameScreen.getMenuActions("main");
        storeActions = (StoreActions) gameScreen.getMenuActions("store");
    }

    // login methods
    public void loginAction(Response response) {
        if (response.getResultCode() == 1 && !response.getRequestType().toString().equals("login_delete")) {
            gameScreen.gotoMenu("main");
        } else {
            loginActions.showError(response.getResultCode());
        }

    }

    public void backToMain(){
        gameScreen.gotoMenu("main");

    }

    public void exitGame(){
        System.exit(0);
    }
    public void store_showBuyableCards(Response response){
        storeActions.showBuyableCards(response.getNamesList(),response.getParameters().get("cardName"),
                response.getParameters().get("wallet"),
                response.getParameters().get("cost"),
                response.getParameters().get("rarity"),
                response.getParameters().get("cardClass"));
    }
    public void store_showSalableCards(Response response){
        storeActions.showSalableCards(response.getNamesList(),response.getParameters().get("cardName"),
                response.getParameters().get("wallet"),
                response.getParameters().get("cost"),
                response.getParameters().get("rarity"),
                response.getParameters().get("cardClass"));
    }
    public void store_selectCard(Response response){
storeActions.selectCard(response.getParameters().get("cardName"),
        response.getParameters().get("wallet"),
        response.getParameters().get("cost"),
        response.getParameters().get("rarity"),
        response.getParameters().get("cardClass"));

    }
    public void store_buyCard(Response response){
storeActions.buyCard(response.getResultCode(),response.getNamesList(),response.getParameters().get("cardName"),
        response.getParameters().get("wallet"),
        response.getParameters().get("cost"),
        response.getParameters().get("rarity"),
        response.getParameters().get("cardClass"));
    }
    public void store_sellCard(Response response){
storeActions.sellCard(response.getNamesList(),response.getParameters().get("cardName"),
        response.getParameters().get("wallet"),
        response.getParameters().get("cost"),
        response.getParameters().get("rarity"),
        response.getParameters().get("cardClass"));
    }
}

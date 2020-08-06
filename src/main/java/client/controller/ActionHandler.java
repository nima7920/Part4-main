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


    }

    public void exitGame(){


    }
    public void store_showBuyableCards(Response response){


    }
    public void store_showSalableCards(Response response){


    }
    public void store_selectCard(Response response){


    }
    public void store_buyCard(Response response){

    }
    public void store_sellCard(Response response){

    }
}

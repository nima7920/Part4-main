package client.controller;

import client.gui.GameScreen;
import client.gui.login.LoginActions;
import client.gui.main.MainActions;
import client_server_interfaces.Response;

public class ActionHandler {

    private GameScreen gameScreen;
    // actions classes
    private LoginActions loginActions;
    private MainActions mainActions;

    public ActionHandler() {
        gameScreen = GameScreen.getInstance();
        initActions();
    }

    private void initActions() {
        loginActions = (LoginActions) gameScreen.getMenuActions("login");
        mainActions = (MainActions) gameScreen.getMenuActions("main");

    }
    // login methods
    public void loginAction(Response response){
        if(response.getResultCode()==1 && !response.getRequestType().toString().equals("login_delete")){
            gameScreen.gotoMenu("main");
        }else{
            loginActions.showError(response.getResultCode());
        }

    }
}

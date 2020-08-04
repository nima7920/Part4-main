package client.controller;

import client.gui.GameScreen;
import client.gui.login.LoginActions;
import client.gui.main.MainActions;

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
}

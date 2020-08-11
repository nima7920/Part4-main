package server.logic.engine;

import server.logic.controllers.CollectionsController;
import server.logic.controllers.LoginController;
import server.logic.controllers.MainController;
import server.logic.controllers.StoreController;
import server.logic.controllers.play.GameController;
import server.logic.controllers.play.MultiPlay;
import server.logic.controllers.play.PreparedPlay;
import server.logic.controllers.play.SinglePlay;
import server.logic.gameState.PlayGroundState;
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
    private CollectionsController collectionsController;
    private GameController gameController;

    private int playMode;

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
        collectionsController = new CollectionsController(responseHandler, playerHandler, cardFactory);

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

    // methods for main
    public void gotoPlay() {
        mainController.gotoPlay();
    }

    public void gotoStore() {
        storeController.sendBuyableCards();
    }

    public void gotoCollections() {
        mainController.gotoCollections();
    }

    public void gotoStatus() {
        mainController.gotoStatus();
    }

    public void exitGame() {

    }

    public void backToMain() {

    }

    // store menu
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

    // collections methods


    // game methods
    public void setGameMode(HashMap<String,String> parameters){
        switch (parameters.get("playMode")){
            case "mutiPlay":{
                gameController=new MultiPlay(playerHandler,cardFactory);
                playMode=1;
                break;
            } case "singlePlay":{
                gameController=new SinglePlay(playerHandler,cardFactory);
                playMode=2;
                break;
            } case "preparedMode":{
                gameController=new PreparedPlay(playerHandler,cardFactory);
                playMode=3;
                break;
            }
        }
    }

    public int getPlayMode() {
        return playMode;
    }

    public void selectPassive(HashMap<String,String> parameters){

    }

    public void startGame(PlayGroundState playGroundState,int playerID){

    }

}

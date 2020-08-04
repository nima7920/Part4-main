package server.logic.engine;

import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

public class Engine {

    private ResponseHandler responseHandler;

    // model handlers for controllers
    private PlayerHandler playerHandler;
    private CardFactory cardFactory;

    // controller objects

    public Engine(ResponseHandler responseHandler){
        this.responseHandler=responseHandler;
        playerHandler=new PlayerHandler();
        cardFactory=new CardFactory();
        initControllers();
    }

    private void initControllers(){

    }

}

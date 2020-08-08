package server.logic.controllers;

import server.logic.engine.ResponseHandler;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

public class MainController extends Controller{


    public MainController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory){
        super(responseHandler,playerHandler,cardFactory);
    }

    public void gotoPlay(){

    }

    public void gotoStore(){

    }

    public void gotoCollections(){

    }
    public void gotoStatus(){

    }
}

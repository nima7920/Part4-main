package server.logic.controllers;

import server.logic.engine.ResponseHandler;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.HashMap;

public class LoginController extends Controller {

    public LoginController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory){
        super(responseHandler,playerHandler,cardFactory);
    }

    public void login(HashMap<String,String> parameters){


    }

    public void sign_up(HashMap<String,String> parameters){


    }

    public void delete(HashMap<String,String> parameters){


    }

}

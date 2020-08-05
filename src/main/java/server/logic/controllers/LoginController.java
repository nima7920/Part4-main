package server.logic.controllers;

import client_server_interfaces.RequestType;
import client_server_interfaces.Response;
import server.logic.engine.ResponseHandler;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

import java.util.HashMap;

public class LoginController extends Controller {

    public LoginController(ResponseHandler responseHandler, PlayerHandler playerHandler, CardFactory cardFactory) {
        super(responseHandler, playerHandler, cardFactory);
    }

    public void login(HashMap<String, String> parameters) {
        Response response = new Response();
        response.setResultCode(playerHandler.login(parameters.get("username"), parameters.get("password")));
        response.setRequestType(RequestType.login_login);
        responseHandler.handleResponse(response);
    }

    public void sign_up(HashMap<String, String> parameters) {
        Response response = new Response();
        response.setResultCode(playerHandler.sign_up(parameters.get("username"), parameters.get("password")));
        response.setRequestType(RequestType.login_signUp);
        responseHandler.handleResponse(response);
    }

    public void delete(HashMap<String, String> parameters) {
        Response response = new Response();
        response.setResultCode(playerHandler.delete(parameters.get("username"), parameters.get("password")));
        response.setRequestType(RequestType.login_delete);
        responseHandler.handleResponse(response);
    }

}

package client.controller;

import client_server_interfaces.Response;

import java.util.HashMap;

public class Receiver {

    private static ActionHandler actionHandler;
    private GsonHandler gsonHandler;

    public Receiver(){
        actionHandler=new ActionHandler();
        gsonHandler=new GsonHandler();
    }

    public void handleResponse(String responseString){
        Response response=gsonHandler.deserializeResponse(responseString);
        if(response!=null){
            RequestTypeClient requestTypeClient=RequestTypeClient.valueOf(response.getRequestType().toString());
            requestTypeClient.execute(response);
        }
    }

    private enum RequestTypeClient implements Executor {
        login_login {
            @Override
            public void execute(Response response) {
actionHandler.loginAction(response);
            }
        }, login_signUp {
            @Override
            public void execute(Response response) {
                actionHandler.loginAction(response);
            }
        }, login_delete {
            @Override
            public void execute(Response response) {
                actionHandler.loginAction(response);
            }
        }

    }
}

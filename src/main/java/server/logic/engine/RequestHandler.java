package server.logic.engine;

import client_server_interfaces.Request;

import java.util.HashMap;

public class RequestHandler {

    private ResponseHandler responseHandler;
    private GsonHandler gsonHandler;
    private Engine engine;

    public RequestHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        this.engine = new Engine(responseHandler);
        gsonHandler = new GsonHandler();
    }

    public void handleRequest(String requestString) {
        Request request = gsonHandler.deserializeRequest(requestString);
        if (request != null) {
            RequestTypeServer requestTypeServer = RequestTypeServer.valueOf(request.getRequestType().toString());
            requestTypeServer.execute(request.getParameters());
        }
    }

    private enum RequestTypeServer implements Executor {
        login_login {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, login_signUp {
            @Override
            public void execute(HashMap<String, String> parameters) {


            }
        }, login_delete {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }
    }
}

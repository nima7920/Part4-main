package server.logic.engine;

import client_server_interfaces.Request;
import server.network.ClientModerator;
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

    }

    private enum RequestType implements Executor {
        login {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, signUp {
            @Override
            public void execute(HashMap<String, String> parameters) {


            }
        },delete{
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }
    }
}

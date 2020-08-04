package server.logic.engine;

import server.network.ClientModerator;

import java.io.PrintWriter;

public class RequestHandler {

    private ResponseHandler responseHandler;
private String authToken;
    public RequestHandler(ResponseHandler responseHandler,String authToken) {
     this.responseHandler=responseHandler;
     this.authToken=authToken;
    }

    public void handleRequest(String requestString){

    }
}

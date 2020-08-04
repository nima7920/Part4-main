package server.logic.engine;

import server.network.ClientModerator;

import java.io.PrintWriter;

public class RequestHandler {

    private ResponseHandler responseHandler;

    public RequestHandler(ResponseHandler responseHandler) {
     this.responseHandler=responseHandler;
    }

}

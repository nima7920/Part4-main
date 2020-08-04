package server.logic.engine;

import client_server_interfaces.Response;
import server.network.ClientModerator;

import java.io.PrintWriter;

public class ResponseHandler {

    private PrintWriter out;
    private ClientModerator clientModerator;
    private GsonHandler gsonHandler;

    public ResponseHandler(ClientModerator clientModerator, PrintWriter out) {
        this.clientModerator = clientModerator;
        this.out = out;
        gsonHandler = new GsonHandler();
    }

    public void handleResponse(Response response) {
        String responseString = gsonHandler.serializeResponse(response);
        out.println(responseString);
    }
}

package server.logic.engine;

import server.network.ClientModerator;

import java.io.PrintWriter;

public class ResponseHandler {

    private PrintWriter out;
    private ClientModerator clientModerator;

    public ResponseHandler(ClientModerator clientModerator, PrintWriter out) {
        this.clientModerator = clientModerator;
        this.out = out;
    }

}

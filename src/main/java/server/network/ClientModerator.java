package server.network;

import server.logic.engine.RequestHandler;
import server.logic.engine.ResponseHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientModerator extends Thread {

    private Socket socket;
    private Server server;
    private String authToken;
    private Scanner in;
    private PrintWriter out;
    private RequestHandler requestHandler;

    public ClientModerator(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        initHandlers();

    }

    private void initHandlers() {
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            requestHandler = new RequestHandler(new ResponseHandler(this, out),authToken);
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            String requestString = in.nextLine();
            requestHandler.handleRequest(requestString);
        }
    }


}
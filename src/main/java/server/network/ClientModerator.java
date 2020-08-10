package server.network;

import server.logic.engine.RequestHandler;
import server.logic.engine.ResponseHandler;
import server.logic.gameState.PlayGroundState;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientModerator extends Thread {

    private Socket socket;
    private Server server;
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
            requestHandler = new RequestHandler(this, new ResponseHandler(this, out));
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                String requestString = in.nextLine();
                requestHandler.handleRequest(requestString);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void requestGame(int playMode) {
        server.requestGame(this,playMode);
    }

    public void startGame(PlayGroundState playGroundState,int playerID){
        requestHandler.startGame(playGroundState,playerID);
    }
}

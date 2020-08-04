package server.network;

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

    public ClientModerator(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        initHandlers();

    }

    private void initHandlers() {
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());

        }catch(IOException e){

        }
    }

    @Override
    public void run() {

    }


}

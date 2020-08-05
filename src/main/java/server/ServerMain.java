package server;

import server.network.Server;

public class ServerMain {

    private static int serverPort=5000;
    public static void main(String[] args) {
        Server server=new Server(serverPort);
        server.start();
    }
}

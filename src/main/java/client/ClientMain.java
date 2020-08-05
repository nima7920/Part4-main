package client;

import client.controller.Client;

public class ClientMain {

    private static int serverPort=5000;
    private static String serverIP="localhost";

    public static void main(String[] args) {
        Client client=new Client(serverIP,serverPort);
        client.start();
    }
}

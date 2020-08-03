package server.network;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {

private int serverPort;
private ServerSocket serverSocket;

public Server(int serverPort){

    this.serverPort=serverPort;
    try {
        serverSocket=new ServerSocket(this.serverPort);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Override
    public void run() {

    }
}

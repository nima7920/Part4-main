package client.controller;

import client.gui.GameScreen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    private Sender sender;
    private Receiver receiver;
    private GameScreen gameScreen;

    public Client(String serverIP, int serverPort) {

        try {
            this.socket = new Socket(serverIP, serverPort);
        } catch (IOException e) {
            e.printStackTrace();

        }
        initTransmitters();
        gameScreen = GameScreen.getInstance();
    }

    private void initTransmitters() {

        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sender = Sender.getInstance();
        sender.setOut(out);
        receiver = new Receiver();
    }

    @Override
    public void run() {
        while (in.hasNext()) {
            String responseString = in.nextLine();
            receiver.handleResponse(responseString);
        }
    }
}

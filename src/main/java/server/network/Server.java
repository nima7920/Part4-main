package server.network;

import server.logic.gameState.PlayGroundState;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private int serverPort;
    private ServerSocket serverSocket;
    private ArrayList<ClientModerator> multiWaitingList,preparedWaitingList;

    public Server(int serverPort) {

        this.serverPort = serverPort;
        multiWaitingList = new ArrayList<>();
preparedWaitingList=new ArrayList<>();
        try {
            serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientModerator clientModerator = new ClientModerator(this, socket);
                clientModerator.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void requestGame(ClientModerator clientModerator, int playMode) {
        if (playMode ==1) {
            multiWaitingList.add(clientModerator);
            checkWaitingList();
        } else if(playMode==2){
            startSinglePlayGame(clientModerator);
        }else{
            preparedWaitingList.add(clientModerator);
            checkWaitingList();
        }
    }

    private synchronized void checkWaitingList() {
        if (multiWaitingList.size() > 1) {
            ClientModerator clientModerator1 = multiWaitingList.get(0), clientModerator2 = multiWaitingList.get(1);
            multiWaitingList.remove(0);
            multiWaitingList.remove(0);
            startMultiPlayGame(clientModerator1, clientModerator2);
        }
        if (preparedWaitingList.size() > 1) {
            ClientModerator clientModerator1 = preparedWaitingList.get(0), clientModerator2 = preparedWaitingList.get(1);
            preparedWaitingList.remove(0);
            preparedWaitingList.remove(0);
            startMultiPlayGame(clientModerator1, clientModerator2);
        }
    }

    private synchronized void startMultiPlayGame(ClientModerator clientModerator1, ClientModerator clientModerator2) {
        PlayGroundState playGroundState = new PlayGroundState();
        clientModerator1.startGame(playGroundState, 0);
        clientModerator2.startGame(playGroundState, 1);
    }

    private synchronized void startSinglePlayGame(ClientModerator clientModerator) {
        clientModerator.startGame(new PlayGroundState(), 0);
    }
}

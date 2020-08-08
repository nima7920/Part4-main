package client.gui.main;

import client.gui.EventHandler;
import client_server_interfaces.Request;
import client_server_interfaces.RequestType;

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class MainActions extends EventHandler {


    private MainMenu mainMenu;

    public MainActions(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Request request;
        HashMap<String, String> parameters = new HashMap<>();

        if (actionEvent.getSource() == mainMenu.playButton) {
            request = new Request(RequestType.main_play, parameters);
        } else if (actionEvent.getSource() == mainMenu.collectionsButton) {
            request = new Request(RequestType.main_collections, parameters);
        } else if (actionEvent.getSource() == mainMenu.storeButton) {
            request = new Request(RequestType.main_store, parameters);
        } else if (actionEvent.getSource() == mainMenu.statusButton) {
            request = new Request(RequestType.main_status, parameters);
        } else { // exit button
            request = new Request(RequestType.exitGame, parameters);
        }
        sender.sendRequest(request);
    }
}

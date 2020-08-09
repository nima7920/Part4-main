package client.gui.play;

import client.gui.EventHandler;
import client_server_interfaces.Request;
import client_server_interfaces.RequestType;

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class PreparationActions extends EventHandler {
    private PreparationMenu preparationMenu;

    public PreparationActions(PreparationMenu preparationMenu) {
        this.preparationMenu = preparationMenu;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Request request;
        HashMap<String, String> parameters = new HashMap<>();
        if (actionEvent.getSource() == preparationMenu.playModePanel.multiPlayButton) {
            parameters.put("playMode", "multiPlay");
            request = new Request(RequestType.preparation_playMode, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == preparationMenu.playModePanel.singlePlayButton) {
            parameters.put("playMode", "singlePlay");
            request = new Request(RequestType.preparation_playMode, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == preparationMenu.playModePanel.preparedModeButton) {
            parameters.put("playMode", "preparedMode");
            request = new Request(RequestType.preparation_playMode, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == preparationMenu.backButton) {
            request = new Request(RequestType.backToMain, parameters);
            sender.sendRequest(request);
        }
    }
}

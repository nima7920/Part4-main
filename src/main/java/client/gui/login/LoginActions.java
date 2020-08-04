package client.gui.login;

import client.gui.EventHandler;
import client_server_interfaces.Request;
import client_server_interfaces.RequestType;

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LoginActions extends EventHandler {

    private LoginMenu loginMenu;

    public LoginActions(LoginMenu loginMenu) {
        this.loginMenu = loginMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // this should show an error
        if (loginMenu.userNameField.getText().trim().equals("") || loginMenu.passwordField.getText().trim().equals("")) {

            return;
        }

        Request request;
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("username", loginMenu.userNameField.getText().trim());
        parameters.put("password", loginMenu.passwordField.getText().trim());

        if (actionEvent.getSource() == loginMenu.loginButton) {
            request = new Request(RequestType.login, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == loginMenu.createButton) {
            request = new Request(RequestType.signUp, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == loginMenu.deleteButton) {
            request = new Request(RequestType.delete, parameters);
            sender.sendRequest(request);
        }
    }

}

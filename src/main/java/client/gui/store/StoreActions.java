package client.gui.store;

import client.gui.EventHandler;
import client.gui.components.Message;
import client_server_interfaces.Request;
import client_server_interfaces.RequestType;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class StoreActions extends EventHandler implements MouseListener {

    private StoreMenu storeMenu;

    public StoreActions(StoreMenu storeMenu) {
        this.storeMenu = storeMenu;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Request request;
        HashMap<String, String> parameters = new HashMap<>();

        if (mouseEvent.getSource() == storeMenu.buyPanel) {
            for (int i = 0; i < storeMenu.buyableGCards.size(); i++) {
                if (storeMenu.buyableGCards.get(i).isMouseInside(mouseEvent)) {
                    storeMenu.infoPanel.selectedCard = storeMenu.buyableGCards.get(i);
                    parameters.put("cardName", storeMenu.buyableGCards.get(i).getName());
                    request = new Request(RequestType.store_cardSelect, parameters);
                    sender.sendRequest(request);
                    break;
                }
            }
        } else if (mouseEvent.getSource() == storeMenu.sellPanel) {
            for (int i = 0; i < storeMenu.salableGCards.size(); i++) {
                if (storeMenu.salableGCards.get(i).isMouseInside(mouseEvent)) {
                    storeMenu.infoPanel.selectedCard = storeMenu.salableGCards.get(i);
                    parameters.put("cardName", storeMenu.salableGCards.get(i).getName());
                    request = new Request(RequestType.store_cardSelect, parameters);
                    sender.sendRequest(request);
                    break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Request request;
        HashMap<String, String> parameters = new HashMap<>();

        if (actionEvent.getSource() == storeMenu.buyCardButton) {
            request = new Request(RequestType.store_buyPanel, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.sellCardButton) {
            request = new Request(RequestType.store_sellPanel, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.backButton) {
            request = new Request(RequestType.store_back, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.exitButton) {
            request = new Request(RequestType.store_exit, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.buy_sellButton) {
            if (storeMenu.infoPanel.selectedCard != null) {
                parameters.put("cardName", storeMenu.infoPanel.selectedCard.getName());
                if (storeMenu.buy_sellButton.getText().equals("Buy")) {
                    request = new Request(RequestType.store_buyCard, parameters);
                } else {
                    request = new Request(RequestType.store_sellPanel, parameters);
                }
                sender.sendRequest(request);
            } else {
                message.showErrorMessage("No Card Selected", "Please select a Card");
            }
//            if (infoPanel.selectedCard == null) {
//                menuAdmin.writeLog("Error", "No card is selected");
//                Message.showErrorMessage("No Card Selected", "Please select a Card");
//            } else {
//                if (Message.showConfirmMessage("warning", "are you sure?")) {
//                    // buying a card
//                    if (buy_sellButton.getText().equals("Buy")) {
//                        // not enough gems
//                        if (menuAdmin.buyCard(infoPanel.selectedCardName) == 0) {
//                            menuAdmin.writeLog("Error", "Not enough gems");
//                            Message.showErrorMessage("Error", "Not enough Gems");
//                        } else { // bought successfully
//                            menuAdmin.writeLog("Buy", "Successful");
//                            updateCards();
//                            buyPanel.repaint();
//                            sellPanel.repaint();
//                            infoPanel.updateCard("");
//                        }
//// selling a card
//                    } else {
//                        menuAdmin.writeLog("Sell", "Successful");
//                        menuAdmin.sellCard(infoPanel.selectedCardName);
//                        updateCards();
//                        buyPanel.repaint();
//                        sellPanel.repaint();
//                        infoPanel.updateCard("");
//                    }
//                }
//            }
        }

    }
}

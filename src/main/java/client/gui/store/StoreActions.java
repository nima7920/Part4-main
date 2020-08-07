package client.gui.store;

import client.gui.EventHandler;
import client_server_interfaces.Request;
import client_server_interfaces.RequestType;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
            request = new Request(RequestType.backToMain, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.exitButton) {
            request = new Request(RequestType.exitGame, parameters);
            sender.sendRequest(request);
        } else if (actionEvent.getSource() == storeMenu.buy_sellButton) {
            if (storeMenu.infoPanel.selectedCard != null) {
                parameters.put("cardName", storeMenu.infoPanel.selectedCard.getName());
                if (storeMenu.buy_sellButton.getText().equals("Buy")) {
                    request = new Request(RequestType.store_buyCard, parameters);
                } else {
                    request = new Request(RequestType.store_sellCard, parameters);
                }
                sender.sendRequest(request);
            } else {
                message.showErrorMessage("No Card Selected", "Please select a Card");
            }
        }

    }


    public void showBuyableCards(ArrayList<String> cardNames, String cardName, String wallet, String cost, String rarity, String cardClass) {

        storeMenu.gotoBuyPanel(cardNames);
        storeMenu.infoPanel.updateCard("");
        storeMenu.infoPanel.updateLabels(wallet, cost, rarity, cardClass);
    }

    public void showSalableCards(ArrayList<String> cardNames, String cardName, String wallet, String cost, String rarity, String cardClass) {

        storeMenu.gotoSellPanel(cardNames);
        storeMenu.infoPanel.updateCard("");
        storeMenu.infoPanel.updateLabels(wallet, cost, rarity, cardClass);
    }

    public void selectCard(String cardName, String wallet, String cost, String rarity, String cardClass) {
        storeMenu.infoPanel.updateCard(cardName);
        storeMenu.infoPanel.updateLabels(wallet, cost, rarity, cardClass);
    }

    public void buyCard(int resultCode, ArrayList<String> cardNames, String cardName, String wallet, String cost, String rarity, String cardClass) {
        if (resultCode == 0) {
            message.showErrorMessage("Error", "Not enough gems");
        }
        storeMenu.gotoBuyPanel(cardNames);
        storeMenu.infoPanel.updateCard(cardName);
        storeMenu.infoPanel.updateLabels(wallet, cost, rarity, cardClass);
    }

    public void sellCard(ArrayList<String> cardNames, String cardName, String wallet, String cost, String rarity, String cardClass) {
        storeMenu.gotoSellPanel(cardNames);
        storeMenu.infoPanel.updateCard(cardName);
        storeMenu.infoPanel.updateLabels(wallet, cost, rarity, cardClass);

    }

}

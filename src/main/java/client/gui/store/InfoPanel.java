package client.gui.store;

import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private StoreMenu storeMenu;

    JLabel walletLabel, costLabel, rarityLabel, classLabel;
    GCard selectedCard;
    String selectedCardName;

    public InfoPanel(StoreMenu storeMenu) {

        this.storeMenu=storeMenu;
        initPanel();

    }

    private void initPanel() {
        setBounds(storeMenu.getGuiConfigLoader().getBounds("infoPanel_bounds"));
        setBorder(BorderFactory.createTitledBorder("Info"));
        setOpaque(false);
        setLayout(null);
        initLabels();
        initButtons();
    }

    private void initLabels() {
// wallet label
        walletLabel = new JLabel("Wallet:");
        walletLabel.setBounds(storeMenu.getGuiConfigLoader().getBounds("walletLabel_bounds"));
        walletLabel.setForeground(storeMenu.getGuiConfigLoader().getColor("labelColor"));
        add(walletLabel);
// rarity label
        rarityLabel = new JLabel("Rarity: ");
        rarityLabel.setBounds(storeMenu.getGuiConfigLoader().getBounds("rarityLabel_bounds"));
        rarityLabel.setForeground(storeMenu.getGuiConfigLoader().getColor("labelColor"));
        add(rarityLabel);
        // class label
        classLabel = new JLabel("Class: ");
        classLabel.setBounds(storeMenu.getGuiConfigLoader().getBounds("classLabel_bounds"));
        classLabel.setForeground(storeMenu.getGuiConfigLoader().getColor("labelColor"));
        add(classLabel);
        // cost label
        costLabel = new JLabel("Cost: ");
        costLabel.setBounds(storeMenu.getGuiConfigLoader().getBounds("costLabel_bounds"));
        costLabel.setForeground(storeMenu.getGuiConfigLoader().getColor("labelColor"));
        add(costLabel);

    }

    private void initButtons() {
        storeMenu.buy_sellButton = new GButton("Buy");
        storeMenu.buy_sellButton.setBounds(storeMenu.getGuiConfigLoader().getBounds("buy_sellButton_bounds"));
        storeMenu.buy_sellButton.addActionListener(storeMenu.actions);
        add(storeMenu.buy_sellButton);

    }

    public void updateCard(String cardName) {
        if (cardName.equals("")) {
            selectedCardName = "";
            selectedCard = null;
        } else {
            selectedCardName = cardName;
            selectedCard = new GCard(storeMenu.getGuiConfigLoader().getSize("infoImageBox_size"), selectedCardName,
                    storeMenu.getGuiConfigLoader().getPoint("infoImageBox_location"));
        }
        repaint();
    }

     void updateLabels(String wallet,String cost,String rarity,String cardClass) {
        walletLabel.setText("Wallet:" + wallet);
        costLabel.setText("Cost:" + cost);
        rarityLabel.setText("Rarity:" + rarity);
        classLabel.setText("Class:" + cardClass);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = storeMenu.addRenderingHint(g);
        if (selectedCard != null) {
            selectedCard.render(g2d);
        }
    }
}

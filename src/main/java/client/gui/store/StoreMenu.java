package client.gui.store;

import client.gui.GameMenu;
import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class StoreMenu extends GameMenu {
    // menu components
    BuyPanel buyPanel;
    SellPanel sellPanel;
    InfoPanel infoPanel;
    GButton buyCardButton, sellCardButton, buy_sellButton, backButton, exitButton;
    JScrollPane showCase;

    // required info
    ArrayList<String> buyableCards, salableCards;
    ArrayList<GCard> buyableGCards, salableGCards;


    StoreActions actions;
    String currentTab;

    public StoreMenu() {
// creating all the objects:
        actions=new StoreActions(this);
        buyPanel = new BuyPanel(this);
        sellPanel = new SellPanel(this);
        infoPanel = new InfoPanel(this);
        initMenu();
//        updateCards();
        repaint();
    }

    private void initMenu() {
        setLayout(null);
        setBounds(guiConfigLoader.getBounds("menuBounds"));
        setSize(guiConfigLoader.getSize("menuSize"));
        setPreferredSize(guiConfigLoader.getSize("menuSize"));
        initShowcase();
        initButtons();
        add(showCase);
        currentTab = "Buy";
        sellPanel.setVisible(false);
        add(infoPanel);
        add(sellCardButton);
        add(buyCardButton);
    }

    private void initShowcase() {
        showCase = new JScrollPane();
        showCase.setBounds(guiConfigLoader.getBounds("showcase_bounds"));
        showCase.setHorizontalScrollBar(null);
        showCase.setViewportView(sellPanel);
        showCase.setOpaque(false);
        showCase.getViewport().setOpaque(false);
        showCase.setViewportView(buyPanel);
        showCase.setOpaque(false);
        showCase.getViewport().setOpaque(false);
    }

    // initializing buttons:
    private void initButtons() {
// buyCardButton:
        buyCardButton = new GButton("Buy Card");
        buyCardButton.setBounds(guiConfigLoader.getBounds("buyCardButton_bounds"));
        buyCardButton.addActionListener(actions);
        add(buyCardButton);
        // sellCardButton:
        sellCardButton = new GButton("Sell Card");
        sellCardButton.setBounds(guiConfigLoader.getBounds("sellCardButton_bounds"));
        sellCardButton.addActionListener(actions);
        add(sellCardButton);
// backButton
        backButton = new GButton("Back");
        backButton.setBounds(guiConfigLoader.getBounds("backButton_bounds"));
        backButton.addActionListener(actions);
        add(backButton);
        // exit button
        exitButton = new GButton("Exit");
        exitButton.setBounds(guiConfigLoader.getBounds("exitButton_bounds"));
        exitButton.addActionListener(actions);
        add(exitButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        paintGraphics(g2d);
    }

    private void paintGraphics(Graphics2D g2d) {

            BufferedImage backgroundImage = imageLoader.getBackgroundImage("Store");
            g2d.drawImage(backgroundImage, 0, 0, guiConfigLoader.getBounds("menuBounds").width,
                    guiConfigLoader.getBounds("menuBounds").height, null);

    }
}

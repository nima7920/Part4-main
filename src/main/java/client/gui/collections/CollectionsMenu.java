package client.gui.collections;

import client.configs.GUIConfigLoader;
import client.gui.GameMenu;
import client.gui.components.GButton;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CollectionsMenu extends GameMenu {

    String currentPanel = "All Cards";
    GButton allCardsButton, decksButton, backButton, exitButton;

    // inner panels
    AllCardsPanel allCardsPanel;
    DecksPanel decksPanel;
    AddCardPanel addCardPanel;
    CreateDeckPanel createDeckPanel;

    public CollectionsMenu() {
        guiConfigLoader = new GUIConfigLoader("collections");
        actions = new CollectionsActions(this);
        initMenu();

    }

    // sets the bounds and other properties of the menu
    private void initMenu() {
        setLayout(null);
        setBounds(guiConfigLoader.getBounds("menuBounds"));
        setSize(guiConfigLoader.getSize("menuBounds"));
        setPreferredSize(guiConfigLoader.getSize("menuBounds"));
        initButtons();
        initPanels();

    }

    private void initButtons() {
        allCardsButton = new GButton("All Cards");
        allCardsButton.setBounds(guiConfigLoader.getBounds("allCardsButton_bounds"));
        allCardsButton.addActionListener(actions);
        add(allCardsButton);

        decksButton = new GButton("Decks");
        decksButton.setBounds(guiConfigLoader.getBounds("decksButton_bounds"));
        decksButton.addActionListener(actions);
        add(decksButton);

        backButton = new GButton("Back");
        backButton.setBounds(guiConfigLoader.getBounds("backButton_bounds"));
        backButton.addActionListener(actions);
        add(backButton);

        exitButton = new GButton("Exit");
        exitButton.setBounds(guiConfigLoader.getBounds("exitButton_bounds"));
        exitButton.addActionListener(actions);
        add(exitButton);

    }

    private void initPanels() {
        allCardsPanel = new AllCardsPanel(this);
        decksPanel = new DecksPanel(this);
        addCardPanel = new AddCardPanel(this);
        createDeckPanel = new CreateDeckPanel(this);
        add(allCardsPanel);
        add(decksPanel);
        add(addCardPanel);
        add(createDeckPanel);
        gotoPanel("All");
    }

    private void gotoPanel(String panelName) {
        allCardsPanel.setVisible(false);
        decksPanel.setVisible(false);
        addCardPanel.setVisible(false);
        createDeckPanel.setVisible(false);
        switch (panelName) {
            case "All": {
                currentPanel = "All";
                allCardsPanel.setVisible(true);
                break;
            }
            case "Decks": {
                currentPanel = "Decks";
                decksPanel.setVisible(true);
                break;
            }
            case "Add Card": {
                currentPanel = "Add Card";
                addCardPanel.setVisible(true);
                break;
            }
            case "Create Deck": {
                currentPanel = "Create Deck";
                createDeckPanel.setVisible(true);
                break;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=addRenderingHint(g);
        paintGraphics(g2d);
    }

    private void paintGraphics(Graphics2D g2d) {
        BufferedImage backgroundImage = imageLoader.getBackgroundImage("Collections");
        g2d.drawImage(backgroundImage, 0, 0, guiConfigLoader.getBounds("menuBounds").width,
                guiConfigLoader.getBounds("menuBounds").height, null);

    }
}

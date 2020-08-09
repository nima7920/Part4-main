package client.gui.collections;

import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.swing.*;
import java.awt.*;

public class CreateDeckPanel extends JPanel {

    private CollectionsMenu collectionsMenu;

    JLabel createDeckHeroLabel, createDeckNameLabel;
    JTextField createDeckNameField;
    GButton createButton, createDeckBackButton;

    private GCard gMage, gRogue, gWarlock, gPaladin, gHunter;

    // menu fields
    private String selectedHero = "Mage";
    private String selectedDeckName = "";

    public CreateDeckPanel(CollectionsMenu collectionsMenu) {
        this.collectionsMenu = collectionsMenu;
    }


    private void initComponents() {

        // labels
        createDeckHeroLabel = new JLabel("Hero Class:Mage");
        createDeckHeroLabel.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        createDeckHeroLabel.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("createDeckHeroLabel_bounds"));
        add(createDeckHeroLabel);

        createDeckNameLabel = new JLabel("Name:");
        createDeckNameLabel.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        createDeckNameLabel.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("createDeckNameLabel_bounds"));
        add(createDeckNameLabel);

        // test field
        createDeckNameField = new JTextField();
        createDeckNameField.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("createDeckNameField_bounds"));
        add(createDeckNameField);

        // buttons
        createButton = new GButton("Create");
        createButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("createButton_bounds"));
        createButton.addActionListener(collectionsMenu.getActions());
        add(createButton);

        createDeckBackButton = new GButton("Back");
        createDeckBackButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("createDeckBackButton_bounds"));
        createDeckBackButton.addActionListener(collectionsMenu.getActions());
        add(createDeckBackButton);

    }

    private void initHeroes() {
        gMage = new GCard(collectionsMenu.getGuiConfigLoader().getSize("createDeckPanelHero_size"),
                "Mage", collectionsMenu.getGuiConfigLoader().getPoint("createDeckGMage_point"));
        gRogue = new GCard(collectionsMenu.getGuiConfigLoader().getSize("createDeckPanelHero_size"),
                "Rogue", collectionsMenu.getGuiConfigLoader().getPoint("createDeckGRogue_point"));
        gWarlock = new GCard(collectionsMenu.getGuiConfigLoader().getSize("createDeckPanelHero_size"),
                "Warlock", collectionsMenu.getGuiConfigLoader().getPoint("createDeckGWarlock_point"));
        gPaladin = new GCard(collectionsMenu.getGuiConfigLoader().getSize("createDeckPanelHero_size"),
                "Paladin", collectionsMenu.getGuiConfigLoader().getPoint("createDeckGPaladin_point"));
        gHunter = new GCard(collectionsMenu.getGuiConfigLoader().getSize("createDeckPanelHero_size"),
                "Hunter", collectionsMenu.getGuiConfigLoader().getPoint("createDeckGHunter_point"));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = collectionsMenu.addRenderingHint(g);
        if (gMage != null && gRogue != null && gWarlock != null && gPaladin != null && gHunter != null) {
            gMage.render(g2d);
            gRogue.render(g2d);
            gWarlock.render(g2d);
            gPaladin.render(g2d);
            gHunter.render(g2d);
            System.out.println("rendered");
        } else {
            System.out.println("Can't Render");
        }
    }

}

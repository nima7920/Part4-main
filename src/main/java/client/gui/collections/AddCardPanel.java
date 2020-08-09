package client.gui.collections;

import client.gui.components.GButton;

import javax.swing.*;

public class AddCardPanel extends JPanel {
    private CollectionsMenu collectionsMenu;

    GButton addCardPanelBackButton;
    Showcase addCardShowcase;
    PalettePanel addCardPalette;

    // fields
    String selectedDeck = "";
    String selectedCard = "";

    public AddCardPanel(CollectionsMenu collectionsMenu) {
        this.collectionsMenu = collectionsMenu;
        setLayout(null);
        setBounds(collectionsMenu.getGuiConfigLoader().getBounds("addCardPanel_bounds"));
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        initComponents();
    }

    private void initComponents() {
        // back button
        addCardPanelBackButton = new GButton("Back");
        addCardPanelBackButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("addCardPanelBackButton_bounds"));
        addCardPanelBackButton.addActionListener(collectionsMenu.getActions());
        add(addCardPanelBackButton);

        // showcase
        addCardShowcase = new Showcase(collectionsMenu.getGuiConfigLoader().getBounds("addCardShowcase_bounds"),
                collectionsMenu.getGuiConfigLoader().getSize("showcaseImage_size"),
                collectionsMenu.getGuiConfigLoader().getInt("addCardShowcase_rowLength"),
                collectionsMenu.getGuiConfigLoader().getInt("addCardShowcase_hAlign"),
                collectionsMenu.getGuiConfigLoader().getInt("addCardShowcase_vAlign"));
        addCardShowcase.addAction((CollectionsActions) collectionsMenu.getActions());
        add(addCardShowcase);
        // palette
        addCardPalette = new PalettePanel(collectionsMenu.getGuiConfigLoader(), "Add");
        addCardPalette.setAction(collectionsMenu.getActions());
        add(addCardPalette);
    }

    public void showCards() {

    }

    public void selectCard(String selectedCard) {

    }
}

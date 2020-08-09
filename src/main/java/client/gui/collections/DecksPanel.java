package client.gui.collections;


import client.gui.components.GButton;

import javax.swing.*;
import java.util.ArrayList;

public class DecksPanel extends JPanel {
    private CollectionsMenu collectionsMenu;

    // components
     JList<String> decksList;
     GButton createDeckButton, deleteDeckButton, addCardButton, changeNameButton, setCurrentButton;
     Showcase decksShowcase;
    PalettePanel deckCardRemovePalette;

    // fields
    ArrayList<String> deckNamesList;
    String selectedDeckName = "";

    public DecksPanel(CollectionsMenu collectionsMenu){
        this.collectionsMenu=collectionsMenu;
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());
        setBounds(collectionsMenu.getGuiConfigLoader().getBounds("decksPanel_bounds"));
        setOpaque(false);
        deckNamesList = new ArrayList<>();
        initButtons();
        initComponents();
    }


    private void initButtons() {
        createDeckButton = new GButton("Create");
        createDeckButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("decksPanel_createButton_bounds"));
        createDeckButton.addActionListener(collectionsMenu.getActions());
        add(createDeckButton);

        deleteDeckButton = new GButton("Delete");
        deleteDeckButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("decksPanel_deleteButton_bounds"));
        deleteDeckButton.addActionListener(collectionsMenu.getActions());
        add(deleteDeckButton);

        addCardButton = new GButton("Add Card");
        addCardButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("decksPanel_addCardButton_bounds"));
        addCardButton.addActionListener(collectionsMenu.getActions());
        add(addCardButton);

        changeNameButton = new GButton("Change Name");
        changeNameButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("deckPanel_changeNameButton_bounds"));
        changeNameButton.addActionListener(collectionsMenu.getActions());
        add(changeNameButton);

        setCurrentButton = new GButton("Set Current");
        setCurrentButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("deckPanel_setCurrentButton"));
        setCurrentButton.addActionListener(collectionsMenu.getActions());
        add(setCurrentButton);
    }

    private void initComponents() {
        // decklist
        decksList = new JList<>();
        decksList.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("deckList_bounds"));
        decksList.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        decksList.setOpaque(false);
        decksList.addListSelectionListener((CollectionsActions) collectionsMenu.getActions());
        add(decksList);

        // decksShowcase
        decksShowcase = new Showcase(collectionsMenu.getGuiConfigLoader().getBounds("decksShowcase_bounds"),
               collectionsMenu.getGuiConfigLoader().getSize("showcaseImage_size"),
                collectionsMenu.getGuiConfigLoader().getInt("decksShowcase_rowLength"),
                collectionsMenu.getGuiConfigLoader().getInt("decksShowcase_hAlign"),
                collectionsMenu.getGuiConfigLoader().getInt("decksShowcase_vAlign"));
        decksShowcase.addAction((CollectionsActions) collectionsMenu.getActions());
        add(decksShowcase);
// deckCardRemovePalette
        deckCardRemovePalette = new PalettePanel(collectionsMenu.getGuiConfigLoader(),"Remove");
        deckCardRemovePalette.setAction(collectionsMenu.getActions());
        add(deckCardRemovePalette);
    }

    // methods for showing data
    void updateDeckList(){

    }

    void updateShowcase(){

    }
}

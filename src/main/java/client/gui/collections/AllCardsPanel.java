package client.gui.collections;

import javax.swing.*;
import java.util.ArrayList;

public class AllCardsPanel extends JPanel {

    private CollectionsMenu collectionsMenu;
    // components
    private JButton allButton, neutralButton, mageButton, rogueButton, warlockButton, paladinButton, hunterButton;
    private JTextField searchField;
    private JSlider manaSortSlider;
    private JRadioButton ownedCardsRadio, notOwnedCardsRadio;
    private ButtonGroup bg;
    private Showcase allCardsShowcase;

    // fields
    private String cardClass = "All";
    private ArrayList<String> allCardsName;


    public AllCardsPanel(CollectionsMenu collectionsMenu) {
        this.collectionsMenu=collectionsMenu;
        setLayout(null);
        setBounds(collectionsMenu.getGuiConfigLoader().getBounds("allCardsPanel_bounds"));
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        initButtons();
        initComponents();
        setShowcase();
    }


    private void initButtons() {
        allButton = new JButton("All");
        allButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("allButton_bounds"));
        allButton.addActionListener(collectionsMenu.getActions());
        add(allButton);

        neutralButton = new JButton("Neutral");
        neutralButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("neutralButton_bounds"));
        neutralButton.addActionListener(collectionsMenu.getActions());
        add(neutralButton);

        mageButton = new JButton("Mage");
        mageButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("mageButton_bounds"));
        mageButton.addActionListener(collectionsMenu.getActions());
        add(mageButton);

        rogueButton = new JButton("Rogue");
        rogueButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("rougeButton_bounds"));
        rogueButton.addActionListener(collectionsMenu.getActions());
        add(rogueButton);

        warlockButton = new JButton("Warlock");
        warlockButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("warlockButton_bounds"));
        warlockButton.addActionListener(collectionsMenu.getActions());
        add(warlockButton);

        paladinButton = new JButton("Paladin");
        paladinButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("paladinButton_bounds"));
        paladinButton.addActionListener(collectionsMenu.getActions());
        add(paladinButton);

        hunterButton = new JButton("Hunter");
        hunterButton.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("hunterButton_bounds"));
        hunterButton.addActionListener(collectionsMenu.getActions());
        add(hunterButton);

    }

    private void initComponents() {
        // search field
        searchField = new JTextField();
        searchField.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("searchField_bounds"));
        searchField.getDocument().addDocumentListener((CollectionsActions) collectionsMenu.getActions());
        add(searchField);
        // slider
        manaSortSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 10, 0);
        manaSortSlider.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("manaSortSlider_bounds"));
        manaSortSlider.setMinorTickSpacing(1);
        manaSortSlider.setMajorTickSpacing(1);
        manaSortSlider.setPaintLabels(true);
        manaSortSlider.setPaintTicks(true);
        manaSortSlider.addChangeListener((CollectionsActions) collectionsMenu.getActions());
        manaSortSlider.setOpaque(false);
        manaSortSlider.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        add(manaSortSlider);
// radio buttons
        ownedCardsRadio = new JRadioButton("Owned", true);
        notOwnedCardsRadio = new JRadioButton("Not owned");
        ownedCardsRadio.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("ownedCardsRadio_bounds"));
        notOwnedCardsRadio.setBounds(collectionsMenu.getGuiConfigLoader().getBounds("notOwnedCardsRadio_bounds"));
        ownedCardsRadio.addActionListener(collectionsMenu.getActions());
        notOwnedCardsRadio.addActionListener(collectionsMenu.getActions());
        ownedCardsRadio.setOpaque(false);
        notOwnedCardsRadio.setOpaque(false);
        ownedCardsRadio.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        notOwnedCardsRadio.setForeground(collectionsMenu.getGuiConfigLoader().generalLabel_foreColor);
        bg = new ButtonGroup();
        bg.add(ownedCardsRadio);
        bg.add(notOwnedCardsRadio);
        add(ownedCardsRadio);
        add(notOwnedCardsRadio);
// showcase
//        allCardsShowcase = new Showcase(collectionsMenu.getGuiConfigLoader().getBounds("allCardsShowcase_bounds"),
//                collectionsMenu.getGuiConfigLoader(),allCardsShowcase_rowLength,
//                GUIConfigLoader.collectionsMenu.allCardsShowcase_hAlign,
//                GUIConfigLoader.collectionsMenu.allCardsShowcase_vAlign);
//        allCardsShowcase.addAction(actions);
//        add(allCardsShowcase);
    }

    void setShowcase() {
// sets the cards that must be shown in showcase
//        allCardsName = (ArrayList) menuAdmin.getCardsWithConditions(cardClass, ownedCardsRadio.isSelected(), manaSortSlider.getValue(), searchField.getText()).clone();
//        allCardsShowcase.updateCardList(allCardsName, notOwnedCardsRadio.isSelected());

    }
}

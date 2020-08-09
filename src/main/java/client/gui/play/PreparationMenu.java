package client.gui.play;

import client.configs.GUIConfigLoader;
import client.gui.GameMenu;
import client.gui.components.GButton;

public class PreparationMenu extends GameMenu {

    GButton backButton;
    PlayModePanel playModePanel;
    PassivePanel passivePanel;
    String currentPanelName;

    public PreparationMenu() {
        guiConfigLoader = new GUIConfigLoader("preparation");
        actions=new PreparationActions(this);
        initMenu();
    }

    private void initMenu() {
        setLayout(null);
        setBounds(guiConfigLoader.getBounds("menuBounds"));
        setSize(guiConfigLoader.getSize("menuBounds"));
        setPreferredSize(guiConfigLoader.getSize("menuBounds"));
        initButtons();
        initPanels();
    }

    private void initPanels() {
        playModePanel = new PlayModePanel(this);
//        passivePanel = new PassivePanel();
        add(playModePanel);
//        add(passivePanel);
        gotoPanel("play mode");
    }

    private void initButtons() {
        backButton = new GButton();
        backButton.setText("Back");
        backButton.setBounds(guiConfigLoader.getBounds("backButton_bounds"));
        backButton.addActionListener(actions);
        add(backButton);
    }

    private void gotoPanel(String panelName) {
//        this.currentPanelName = panelName;
//        playModePanel.setVisible(false);
//        passivePanel.setVisible(false);
//
//        if (currentPanelName.equals("play mode")) {
//            playModePanel.setVisible(true);
//
//        } else if (currentPanelName.equals("passive")) {
//            passivePanel.setVisible(true);
//
//        }
    }
}

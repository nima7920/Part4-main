package client.gui.play;

import client.gui.components.GButton;

import javax.swing.*;

public class PlayModePanel extends JPanel {
    private PreparationMenu preparationMenu;

    GButton multiPlayButton, singlePlayButton, preparedModeButton;

    public PlayModePanel(PreparationMenu preparationMenu) {
        this.preparationMenu = preparationMenu;
        initPanel();
    }

    private void initPanel() {
        setLayout(null);
        setBounds(preparationMenu.getGuiConfigLoader().getBounds("playModePanel_bounds"));
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        initButtons();
    }

    private void initButtons() {
        multiPlayButton = new GButton(preparationMenu.getGuiConfigLoader().getString("selfPlayButton_text"));
        multiPlayButton.setBounds(preparationMenu.getGuiConfigLoader().getBounds("selfPlayButton_bounds"));
        multiPlayButton.addActionListener(preparationMenu.getActions());
        add(multiPlayButton);

        singlePlayButton = new GButton(preparationMenu.getGuiConfigLoader().getString("preparedModeButton_text"));
        singlePlayButton.setBounds(preparationMenu.getGuiConfigLoader().getBounds("preparedModeButton_bounds"));
        singlePlayButton.addActionListener(preparationMenu.getActions());
        add(singlePlayButton);

        preparedModeButton = new GButton(preparationMenu.getGuiConfigLoader().getString("computerModeButton_text"));
        preparedModeButton.setBounds(preparationMenu.getGuiConfigLoader().getBounds("computerModeButton_bounds"));
        preparedModeButton.addActionListener(preparationMenu.getActions());
        add(preparedModeButton);
    }
}

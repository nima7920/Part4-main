package client.gui.play;

import client.gui.components.GButton;

import javax.swing.*;

public class PassivePanel extends JPanel {
    private PreparationMenu preparationMenu;
    GButton passive1, passive2, passive3;

    public PassivePanel(PreparationMenu preparationMenu) {
        this.preparationMenu = preparationMenu;
    }

    private void initPanel() {
        setLayout(null);
        setBounds(preparationMenu.getGuiConfigLoader().getBounds("passivePanel_bounds"));
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        initButtons();
    }

    private void initButtons() {
        passive1 = new GButton();
        passive1.setBounds(preparationMenu.getGuiConfigLoader().getBounds("passive1Button_bounds"));
        passive1.addActionListener(preparationMenu.getActions());
        add(passive1);

        passive2 = new GButton();
        passive2.setBounds(preparationMenu.getGuiConfigLoader().getBounds("passive2Button_bounds"));
        passive2.addActionListener(preparationMenu.getActions());
        add(passive2);

        passive3 = new GButton();
        passive3.setBounds(preparationMenu.getGuiConfigLoader().getBounds("passive3Button_bounds"));
        passive3.addActionListener(preparationMenu.getActions());
        add(passive3);
    }

//    private void refresh() {
//        passive1.setText(playAdmin.getPassiveText(0));
//        passive2.setText(playAdmin.getPassiveText(1));
//        passive3.setText(playAdmin.getPassiveText(2));
//    }

}

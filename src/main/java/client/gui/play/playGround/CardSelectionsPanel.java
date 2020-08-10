package client.gui.play.playGround;

import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.swing.*;

public class CardSelectionsPanel extends JPanel {

    private PlayMenu playMenu;

    GCard[] cards = new GCard[3];
    GButton doneButton;

    boolean changedCards[] = new boolean[3];

    public CardSelectionsPanel(PlayMenu playMenu) {
        this.playMenu = playMenu;
        initMenu();
    }

    private void initMenu(){
        setLayout(null);
        setBounds(playMenu.getGuiConfigLoader().getBounds("cardSelectionPanel_bounds"));
        setOpaque(false);
        addMouseListener((PlayActions) playMenu.getActions());
        initWaitingLabel();
        repaint();

    }

    private void initDoneButton() {
        doneButton = new GButton("Done");
        doneButton.setBounds(playMenu.getGuiConfigLoader().getBounds("cardSelection_doneButton_bounds"));
        doneButton.addActionListener(playMenu.getActions());
        add(doneButton);
    }

    private void initWaitingLabel(){

    }

  // method will be used from playActions to show cards
    public void showCards(){
        initDoneButton();

    }
}

package client.gui.play.playGround;

import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private PlayMenu playMenu;

    // components
    private JLabel messageLabel, timerLabel;
    private GCard infoCard;
    private GButton backButton, exitButton;
    // fields
    private String cardName = "";
    private Dimension cardDimension;
    private Point cardLocation;

    public InfoPanel(PlayMenu playMenu) {
        this.playMenu = playMenu;

    }

    private void initComponents() {
        initButtons();
        initLabels();

    }

    private void initButtons() {
        backButton = new GButton("back");
        backButton.setBounds(playMenu.getGuiConfigLoader().getBounds("infoPanel_backButton"));
        backButton.addActionListener(playMenu.getActions());
        add(backButton);

        exitButton = new GButton("exit");
        exitButton.setBounds(playMenu.getGuiConfigLoader().getBounds("infoPanel_exitButton"));
        exitButton.addActionListener(playMenu.getActions());
        add(exitButton);
    }

    private void initLabels() {
        messageLabel = new JLabel();
        messageLabel.setBounds(playMenu.getGuiConfigLoader().getBounds("infoPanel_messageLabel_bounds"));
        messageLabel.setFont(playMenu.getGuiConfigLoader().getFont("infoPanel_messageLabel_font"));
        messageLabel.setForeground(playMenu.getGuiConfigLoader().getColor("infoPanel_messageLabel_foreColor"));
        add(messageLabel);

        timerLabel = new JLabel();
        timerLabel.setBounds(playMenu.getGuiConfigLoader().getBounds("infoPanel_timerLabel_bounds"));
        timerLabel.setFont(playMenu.getGuiConfigLoader().getFont("infoPanel_timerLabel_font"));
        timerLabel.setForeground(playMenu.getGuiConfigLoader().getColor("infoPanel_timerLabel_foreColor"));
        add(timerLabel);

    }

    private void initFields() {
        cardDimension = playMenu.getGuiConfigLoader().getSize("infoPanel_infoCard");
        cardLocation = playMenu.getGuiConfigLoader().getPoint("infoPanel_infoCard");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = playMenu.addRenderingHint(g);
        if (infoCard != null) {
            infoCard.render(g2d);
        }
    }

    public void setInfoCardName(String name) {
        if (name.equals(""))
            infoCard = null;
        else
            infoCard = new GCard(cardDimension, name, cardLocation);
        repaint();
    }

    public void setMessageText(String text) {
        messageLabel.setText(text);
    }

    public void setTimerText(String text) {
        timerLabel.setText(text);
    }
}

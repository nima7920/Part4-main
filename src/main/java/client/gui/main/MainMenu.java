package client.gui.main;

import client.gui.GameMenu;
import client.gui.components.GButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu extends GameMenu {

    private GButton playButton, storeButton, statusButton, collectionsButton, settingsButton, exitButton;
    private MainActions actions;

    public MainMenu() {
        actions=new MainActions();
        initMenu();
        initButtons();

        repaint();
    }

    private void initMenu() {
        setLayout(null);
        setBounds(guiConfigLoader.getBounds("menuBounds"));

    }

    private void initButtons() {


        playButton = new GButton("Play");
        playButton.setBounds(guiConfigLoader.getBounds("playButton_bounds"));
        playButton.addActionListener(actions);
        add(playButton);

        storeButton = new GButton("Store");
        storeButton.setBounds(guiConfigLoader.getBounds("storeButton_bounds"));
        storeButton.addActionListener(actions);
        add(storeButton);

        statusButton = new GButton("Status");
        statusButton.setBounds(guiConfigLoader.getBounds("statusButton_bounds"));
        statusButton.addActionListener(actions);
        add(statusButton);

        collectionsButton = new GButton("Collections");
        collectionsButton.setBounds(guiConfigLoader.getBounds("collectionsButton_bounds"));
        collectionsButton.addActionListener(actions);
        add(collectionsButton);

        settingsButton = new GButton("Settings");
        settingsButton.setBounds(guiConfigLoader.getBounds("settingsButton_bounds"));
        settingsButton.addActionListener(actions);
        add(settingsButton);

        exitButton = new GButton("Quit");
        exitButton.setBounds(guiConfigLoader.getBounds("exitButton_bounds"));
        exitButton.addActionListener(actions);
        add(exitButton);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        paintGraphics(g2d);
    }

    private void paintGraphics(Graphics2D g2d) {
            BufferedImage backgroundImage =imageLoader.getBackgroundImage("Main");
            g2d.drawImage(backgroundImage, 0, 0, guiConfigLoader.getBounds("menuBounds").width,
                    guiConfigLoader.getBounds("menuBounds").height, null);

    }
}

package client.gui;

import client.configs.GUIConfigLoader;
import client.configs.ImageLoader;
import client.gui.components.Message;

import javax.swing.*;
import java.awt.*;

public abstract class GameMenu extends JPanel {

    protected GUIConfigLoader guiConfigLoader;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    protected EventHandler actions;

    public GameMenu() {

    }

    public Graphics2D addRenderingHint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        return g2d;
    }

    public GUIConfigLoader getGuiConfigLoader() {
        return guiConfigLoader;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public EventHandler getActions() {
        return actions;
    }
}

package client.gui.collections;

import client.configs.GUIConfigLoader;
import client.gui.components.GButton;
import client.gui.components.GCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PalettePanel extends JPanel {
    GButton paletteButton;
    String paletteCard;
    GCard paletteGCard;
    private GUIConfigLoader guiConfigLoader;

    public PalettePanel(GUIConfigLoader guiConfigLoader, String buttonText) {
        this.guiConfigLoader = guiConfigLoader;
        setLayout(null);
        setBounds(guiConfigLoader.getBounds("palettePanel_bounds"));
        setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        paletteButton = new GButton(buttonText);
        paletteButton.setBounds(guiConfigLoader.getBounds("palettePanelButton_bounds"));
        add(paletteButton);
    }

    public void setAction(ActionListener actionListener) {
        paletteButton.addActionListener(actionListener);
    }

    public void updateCard(String cardName) {
        this.paletteCard = cardName;
        if (paletteCard.equals("")) {
            paletteGCard = null;
        } else {
            paletteGCard = new GCard(guiConfigLoader.getSize("paletteGCard_size"), paletteCard,
                    guiConfigLoader.getPoint("paletteGCard_point"));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        if (paletteGCard != null) {
            paletteGCard.render(g2d);
        }
    }

    private Graphics2D addRenderingHint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        return g2d;
    }
}

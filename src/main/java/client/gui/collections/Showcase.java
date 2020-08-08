package client.gui.collections;

import client.configs.GUIConfigLoader;
import client.gui.components.GCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Showcase extends JScrollPane {
    private ShowcasePanel showcasePanel;
    private int rowLength, horizontalAlign, verticalAlign;
    private ArrayList<String> showcaseCards;
    private ArrayList<GCard> showcaseGCards;
    private Dimension imageSize;

    public Showcase(Rectangle bounds, Dimension imageSize ,int rowLength, int horizontalAlign, int verticalAlign) {
        this.imageSize = imageSize;
        this.rowLength = rowLength;
        this.horizontalAlign = horizontalAlign;
        this.verticalAlign = verticalAlign;
        setBounds(bounds);
        setHorizontalScrollBar(null);
        setPreferredSize(new Dimension(bounds.width, bounds.height));
        showcasePanel = new ShowcasePanel(getPreferredSize());
        setViewportView(showcasePanel);
        setOpaque(false);
        getViewport().setOpaque(false);
        showcaseCards = new ArrayList<>();
        showcaseGCards = new ArrayList<>();
    }

    public void updateCardList(ArrayList<String> cards, boolean isLocked) {
        this.setShowcaseCards(cards);
        showcaseGCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            GCard gCard = new GCard(imageSize, cards.get(i), cardPos(i));
            gCard.setLocked(isLocked);
            showcaseGCards.add(gCard);
        }
        showcasePanel.repaint();
    }

    public void addAction(MouseListener mouseListener) {
        showcasePanel.addMouseListener(mouseListener);
    }

    // a panel for painting the cards in a showcase
    private class ShowcasePanel extends JPanel {
        public ShowcasePanel(Dimension panelSize) {
            setLayout(null);
            setBounds(0, 0, panelSize.width, panelSize.height);
            setPreferredSize(panelSize);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = addRenderingHint(g);
            if (showcaseGCards != null && showcaseGCards.size() > 0) {
                for (int i = 0; i < showcaseGCards.size(); i++) {
                    showcaseGCards.get(i).render(g2d);
                }
                int x = showcaseGCards.get(showcaseGCards.size() - 1).getyPos() + imageSize.height + 20;
                updateSize(x);
            }
        }

        private void updateSize(int newHeight) {
            setPreferredSize(new Dimension(getSize().width, Math.max(newHeight, getSize().height)));
        }

    }

    private Point cardPos(int i) {
        int column = i % rowLength, row = i / rowLength;
        int x = horizontalAlign +
                column * (imageSize.width + horizontalAlign);
        int y = verticalAlign +
                row * (imageSize.height + verticalAlign);
        return new Point(x, y);
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

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public void setHorizontalAlign(int horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public void setVerticalAlign(int verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public void setShowcaseCards(ArrayList<String> showcaseCards) {
        this.showcaseCards = showcaseCards;
    }

    public ArrayList<String> getShowcaseCards() {
        return showcaseCards;
    }
}

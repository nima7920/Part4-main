package client.gui.store;

import javax.swing.*;
import java.awt.*;

public class BuyPanel extends JPanel {

    private StoreMenu storeMenu;

    public BuyPanel(StoreMenu storeMenu) {
        this.storeMenu=storeMenu;
        setLayout(null);
        initPanel();
    }

    private void initPanel() {
        setBounds(storeMenu.getGuiConfigLoader().getBounds("buy_sellPanel_bounds"));
        setPreferredSize(storeMenu.getGuiConfigLoader().getSize("buy_sellPanel_size"));
        setOpaque(false);
//        addMouseListener(storeMenu.getActions());
    }

    private void updateScrolls(int y) {
        setPreferredSize(new Dimension(storeMenu.getGuiConfigLoader().getSize("buy_sellPanel_size").width,
                Math.max(storeMenu.getGuiConfigLoader().getSize("buy_sellPanel_size").height, y)));
        storeMenu.showCase.setViewportView(this);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = storeMenu.addRenderingHint(g);
        if (storeMenu.buyableGCards != null) {
            for (int i = 0; i < storeMenu.buyableGCards.size(); i++) {
                storeMenu.buyableGCards.get(i).render(g2d);
            }
            updateScrolls(storeMenu.cardPos(storeMenu.buyableGCards.size() + 4).y);
        }
    }
}

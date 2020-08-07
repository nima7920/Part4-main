package client.gui.store;

import javax.swing.*;
import java.awt.*;

public class SellPanel extends JPanel {

    private StoreMenu storeMenu;

    public SellPanel(StoreMenu storeMenu) {
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
        if(storeMenu.salableGCards!=null) {
            for (int i = 0; i < storeMenu.salableGCards.size(); i++) {
                storeMenu.salableGCards.get(i).render(g2d);
            }
            updateScrolls(storeMenu.cardPos(storeMenu.salableGCards.size() + 4).y);
        }
    }
}

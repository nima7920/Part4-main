package client.gui.components;

import client_server_interfaces.playGround.GamerHero;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GHero extends GraphicalObject{

    private Rectangle heroBox;
    private int hp;
    private GamerHero gamerHero;
    private GWeapon heroWeapon;
    private Point weaponLocation;

    public GHero(Dimension dimension, GamerHero gamerHero, Point location, Point weaponLocation) {
        this.name = gamerHero.getName();
        this.dimension = dimension;
        this.xPos = location.x;
        this.yPos = location.y;
        this.weaponLocation = weaponLocation;
        this.heroBox = new Rectangle(xPos, yPos, dimension.width, dimension.height);
        this.gamerHero = gamerHero;
        objectImage=imageLoader.getHeroImage(name);
        sync();
    }

    public void sync() {
        this.hp = gamerHero.getHp();
        syncWeapon();
    }

    private void syncWeapon() {
        if (gamerHero.getGamerWeapon() != null) {
            this.heroWeapon = new GWeapon(guiConfigLoader.getSize("GWeapon_size"), gamerHero.getGamerWeapon(), weaponLocation);
        } else {
            heroWeapon = null;
        }

    }
    // this method should render weapon
    public void render(Graphics2D g2d) {
        g2d.drawImage(objectImage, xPos, yPos, dimension.width, dimension.height, null);
        drawText(g2d);
        if (heroWeapon != null)
            heroWeapon.render(g2d);
    }

    private void drawText(Graphics2D g2d) {
        g2d.setPaint(Color.WHITE);
        g2d.setFont(new Font(guiConfigLoader.getString("GHero_font_name"), Font.BOLD,
                guiConfigLoader.getInt("GHero_font_size")));
        g2d.drawString(hp + "", getxPos() + guiConfigLoader.getInt("GHero_hp_x"),
                getyPos() + guiConfigLoader.getInt("GHero_hp_y"));
    }

    public boolean isMouseInside(MouseEvent e) {
        if (heroBox.contains(e.getPoint())) {
            return true;
        }
        return false;
    }
}

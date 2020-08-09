package client.gui.play;

import client.configs.GUIConfigLoader;
import client.gui.GameMenu;

public class PreparationMenu extends GameMenu {

    public PreparationMenu() {
        guiConfigLoader = new GUIConfigLoader("preparation");
        actions=new PreparationActions(this);
    }
}

package client.gui.play.playGround;

import client.configs.GUIConfigLoader;
import client.gui.GameMenu;

public class PlayMenu extends GameMenu {

    public PlayMenu(){
        this.guiConfigLoader=new GUIConfigLoader("play");
        this.actions=new PlayActions(this);
    }
}

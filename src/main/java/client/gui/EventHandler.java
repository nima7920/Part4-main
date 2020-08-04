package client.gui;

import client.controller.Sender;
import client.gui.components.Message;

import java.awt.event.ActionListener;

// a class for handling events in menus
// fields for communicating with server will be added

public abstract class EventHandler implements ActionListener {
    protected Message message=new Message();
    protected Sender sender=Sender.getInstance();

}

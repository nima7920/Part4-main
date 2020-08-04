package gui;

import client.gui.GameMenu;
import client.gui.login.LoginMenu;
import client.gui.main.MainMenu;

import javax.swing.*;

public class MenuTest extends JFrame {

    public MenuTest(GameMenu gameMenu){
        setLayout(null);
        setResizable(false);
//        initMenus();
//        //gameFrame.add(mainMenu);
        setSize(gameMenu.getSize());
        getContentPane().add(gameMenu);
        setVisible(true);
        setLocationRelativeTo(null);
//
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MenuTest(new MainMenu());
    }
}

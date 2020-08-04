package client.gui;

import client.gui.login.LoginMenu;
import client.gui.main.MainMenu;

import javax.swing.*;
import java.util.HashMap;

public class GameScreen {

    // declaring game menus
    private GameMenu currentMenu;
//    private PlayMenu playMenu;
    private LoginMenu loginMenu;
    private MainMenu mainMenu;
//    private StoreMenu storeMenu;
//    private StatusMenu statusMenu;
//    private CollectionsMenu collectionsMenu;
//    private PreparationMenu preparationMenu;


    private HashMap<String, GameMenu> menus;

    private JFrame gameFrame;
    private static GameScreen gameScreen;

    private GameScreen() {
        initMenus();
        menus = new HashMap<>();
        initMenuMap();
        initFrame();
    }

    public static GameScreen getInstance() {
        if (gameScreen == null)
            gameScreen = new GameScreen();
        return gameScreen;
    }

    private void initMenus() {
        loginMenu=new LoginMenu();
        mainMenu=new MainMenu();
    }

    private void initFrame() {
        gameFrame = new JFrame("HearthStone");
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setSize(loginMenu.getSize());
        gameFrame.getContentPane().add(loginMenu);
        loginMenu.setVisible(true);
        currentMenu = loginMenu;
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }

    private void initMenuMap() {
        menus.put("login", loginMenu);
        menus.put("main", mainMenu);
//        menus.put("play", playMenu);
//        menus.put("store", storeMenu);
//        menus.put("status", statusMenu);
//        menus.put("collections", collectionsMenu);
//        menus.put("preparation", preparationMenu);
    }

    public void gotoMenu(String menuName) {
        gameFrame.getContentPane().removeAll();
        currentMenu = menus.get(menuName);
        gameFrame.setSize(currentMenu.getSize());
        currentMenu.setVisible(true);
        gameFrame.getContentPane().add(currentMenu);
        currentMenu.revalidate();
        currentMenu.repaint();
        gameFrame.setLocationRelativeTo(null);
    }



    public EventHandler getMenuActions(String menuName){
        return menus.get(menuName).getActions();
    }
//    void refreshPlayMenu() {
//        playMenu.refresh();
//    }

//    public void refreshStatusMenu() {
//        statusMenu.initTables();
//    }

}

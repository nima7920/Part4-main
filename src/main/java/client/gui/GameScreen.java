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
        initFrame();
    }

    public static GameScreen getInstance() {
        if (gameScreen == null)
            gameScreen = new GameScreen();
        return gameScreen;
    }

    private void initFrame() {
        loginMenu = new LoginMenu();
//        MainMenu mainMenu = new MainMenu();

        gameFrame = new JFrame("HearthStone");
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
//        initMenus();
//        //gameFrame.add(mainMenu);
        gameFrame.setSize(loginMenu.getSize());
        gameFrame.getContentPane().add(loginMenu);
        loginMenu.setVisible(true);
        currentMenu = loginMenu;
        gameFrame.setLocationRelativeTo(null);
//
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        menus = new HashMap<>();
        initMenuMap();
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
        initMenu(menuName);
//        if(menuName.equals("main"))
//            playMenu=null;
        currentMenu = menus.get(menuName);

        gameFrame.setSize(currentMenu.getSize());
        currentMenu.setVisible(true);
        gameFrame.getContentPane().add(currentMenu);
        currentMenu.revalidate();
        currentMenu.repaint();
        gameFrame.setLocationRelativeTo(null);

    }

    private void initMenu(String menuName) {
        if (menus.get(menuName) == null) {
            switch (menuName) {
                case "login": {
                    loginMenu = new LoginMenu();
                    menus.put(menuName, loginMenu);
                    break;
                }
                case "main": {
                    mainMenu = new MainMenu();
                    menus.put(menuName, mainMenu);
                    break;
                }
//                case "play": {
//                    playMenu = new PlayMenu();
//                    menus.put(menuName, playMenu);
//                    break;
//                }
//                case "store": {
//                    storeMenu = new StoreMenu();
//                    menus.put(menuName, storeMenu);
//                    break;
//                }
//                case "collections": {
//                    collectionsMenu = new CollectionsMenu();
//                    menus.put(menuName, collectionsMenu);
//                    break;
//                }
//                case "status": {
//                    statusMenu = new StatusMenu();
//                    menus.put(menuName, statusMenu);
//                    break;
//                }
//                case "preparation": {
//                    preparationMenu = new PreparationMenu();
//                    menus.put(menuName, preparationMenu);
//                    break;
//                }
            }
        }
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

package client.gui.login;

import client.configs.GUIConfigLoader;
import client.gui.GameMenu;
import client.gui.components.GButton;

import javax.swing.*;

public class LoginMenu extends GameMenu {

    private GButton loginButton, createButton;
    private JTextField userNameField, passwordField;
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
private LoginActions actions;
    public LoginMenu() {
        // setting buttons:
        guiConfigLoader=new GUIConfigLoader("login");
        setBounds(guiConfigLoader.getBounds("menuBounds"));
        setLayout(null);
        initButtons();
        initLabels();
        initTextFields();

        requestFocus();

    }

    private void initButtons() {
        actions = new LoginActions();

        loginButton = new GButton("Login");
        loginButton.setBounds(guiConfigLoader.getBounds("loginButton_bounds"));
        loginButton.addActionListener(actions);
        add(loginButton);

        createButton = new GButton("Sign up");
        createButton.setBounds(guiConfigLoader.getBounds("createButton_bounds"));
        createButton.addActionListener(actions);
        add(createButton);

    }

    private void initLabels() {
        welcomeLabel = new JLabel("Welcome to HearthStone!!");
        welcomeLabel.setBounds(guiConfigLoader.getBounds("welcomeLabel_bounds"));
        welcomeLabel.setFont(guiConfigLoader.getFont("welcomeLabel_font"));
        add(welcomeLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(guiConfigLoader.getBounds("usernameLabel_bounds"));
        usernameLabel.setFont(guiConfigLoader.getFont("usernameLabel_font"));
        add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(guiConfigLoader.getBounds("passwordLabel_bounds"));
        passwordLabel.setFont(guiConfigLoader.getFont("passwordLabel_font"));
        add(passwordLabel);

    }

    private void initTextFields() {
        userNameField = new JTextField();
        userNameField.setBounds(guiConfigLoader.getBounds("usernameField_bounds"));
        add(userNameField);

        passwordField = new JTextField();
        passwordField.setBounds(guiConfigLoader.getBounds("passwordField_bounds"));
        add(passwordField);

    }
}

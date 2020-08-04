package client.gui.components;

import javax.swing.*;

public class Message {
    public void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    public boolean showConfirmMessage(String title, String message) {
        int answer = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }

    }
    public String showInputBox(String title,String message){

        return JOptionPane.showInputDialog(null,message,title,JOptionPane.OK_OPTION);
    }
}

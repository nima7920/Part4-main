package server.models.handlers;


import server.models.player.Player;

public class PlayerHandler {

    private Player currentPlayer;
    private PlayerModerator playerModerator;
    private CardFactory cardFactory;

    public PlayerHandler(){
        cardFactory=new CardFactory();
    }

    public int sign_up(String name,String password){

        return 0;
    }

    public int login(String name,String password){

        return 0;
    }

    public int delete(String name,String password){


        return 0;
    }


}

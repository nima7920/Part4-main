package server.models.handlers;


import server.models.player.Deck;
import server.models.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerHandler {

    private Player currentPlayer;
    private PlayerModerator playerModerator;
    private CardFactory cardFactory;

    public PlayerHandler() {
        cardFactory = new CardFactory();
        playerModerator = new PlayerModerator();
    }

    // returns 0 if player exists , 1 otherwise
    public int sign_up(String name, String password) {
        if (playerModerator.isPlayerExist(name)) {
            return 0;
        } else {
            currentPlayer = new Player(name, password, System.currentTimeMillis(), 100);
            playerModerator.savePlayer(currentPlayer);
            return 1;
        }

    }

    // returns 0 if player doesn't exist , -1 if password is wrong , 1 if successfully loaded
    public int login(String name, String password) {

        if (!(playerModerator.isPlayerExist(name))) {
            return 0;
        } else if (!playerModerator.isPasswordCorrect(name, password)) {
            return -1;
        }
        currentPlayer = playerModerator.getPlayer(name);
        syncDecks();
        return 1;
    }

    private void syncDecks() {
        for (Deck deck : currentPlayer.getDecks()) {
            deck.syncCards();
        }
    }

    // returns -1 if password is wrong , 0 if account doesn't exist , 1 if successful
    public int delete(String name, String password) {
        if (!(playerModerator.isPlayerExist(name))) {
            return 0;
        } else if (!playerModerator.isPasswordCorrect(name, password)) {
            return -1;
        }
        playerModerator.deletePlayer(name);
        return 1;
    }

    public ArrayList<String> getOwnedCardsName() {
        return (ArrayList)currentPlayer.getOwnedCardsName();
    }


}

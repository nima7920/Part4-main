package server.models.handlers;

import server.models.player.Player;

public class PlayerModerator {

    private DataBaseHandler dataBaseHandler;

    public PlayerModerator() {
        dataBaseHandler = new DataBaseHandler();
    }

    public boolean isPlayerExist(String name) {

        if (dataBaseHandler.fetch(Player.class, name) == null) {
            return false;
        } else {
            return true;
        }
    }


    public boolean isPasswordCorrect(String name, String password) {
        if (isPlayerExist(name)) {
            Player player = dataBaseHandler.fetch(Player.class, name);
            if (player.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Player getPlayer(String name) {

        return dataBaseHandler.fetch(Player.class, name);
    }

    public void deletePlayer(String name) {
        Player player = dataBaseHandler.fetch(Player.class, name);
        dataBaseHandler.delete(player);
    }

    public void savePlayer(Player player) {
        dataBaseHandler.save(player);

    }
}

package server.logic.controllers.play;

import server.logic.gameState.PlayGroundState;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

public class PreparedPlay extends GameController{

    public PreparedPlay(PlayerHandler playerHandler, CardFactory cardFactory){
        this.playerHandler=playerHandler;
        this.cardFactory=cardFactory;
    }

    @Override
    public void startGame(PlayGroundState playGroundState, int playerID) {

    }

    @Override
    public void loadDeck() {

    }

    @Override
    public void playCard(int originIndex, int targetIndex) {

    }

    @Override
    public void attack(int originIndex, int targetIndex) {

    }

    @Override
    public void endTurn() {

    }
}

package server.logic.controllers.play;

import server.logic.gameState.GamerHeroPowerState;
import server.logic.gameState.GamerHeroState;
import server.logic.gameState.PlayGroundState;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;
import server.models.heroes.Hero;

public class MultiPlay extends GameController {

    public MultiPlay(PlayerHandler playerHandler, CardFactory cardFactory) {
        this.playerHandler = playerHandler;
        this.cardFactory = cardFactory;
    }

    @Override
    public void startGame(PlayGroundState playGroundState, int playerID) {
        this.playerID = playerID;
        this.playGroundState = playGroundState;
        loadGamer();
    }

    @Override
    public void loadGamer() {
        playGroundState.getGamer(playerID).setDeckCards(playerHandler.getCurrentDeck().getClone().getCards());
        playGroundState.getGamer(playerID).setGamerHero(
                new GamerHeroState(Hero.getHeroFromName(playerHandler.getCurrentDeck().getHeroClass().toString())));
        playGroundState.getGamer(playerID).setGamerHeroPower(
                new GamerHeroPowerState(Hero.getHeroFromName(playerHandler.getCurrentDeck().getHeroClass().toString()).getHeroPower()));

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

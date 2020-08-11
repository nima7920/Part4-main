package server.logic.controllers.play;

import server.logic.gameState.PlayGroundState;
import server.logic.util.PlayGroundConverter;
import server.logic.util.PlayGroundEditor;
import server.logic.visitors.CardPlayVisitor;
import server.logic.visitors.DeathRattleVisitor;
import server.logic.visitors.PassiveEndTurnVisitor;
import server.logic.visitors.PowerActionVisitor;
import server.models.handlers.CardFactory;
import server.models.handlers.PlayerHandler;

public abstract class GameController {

    protected int playerID;
    protected PlayerHandler playerHandler;
    protected CardFactory cardFactory;
    // playState fields
    protected PlayGroundState playGroundState;
    protected PlayGroundEditor playGroundEditor;
    protected PlayGroundConverter playGroundConverter;
   // visitors
    protected CardPlayVisitor cardPlayVisitor;
    protected PowerActionVisitor powerActionVisitor;
    protected DeathRattleVisitor deathRattleVisitor;
    protected PassiveEndTurnVisitor passiveEndTurnVisitor;

    public abstract void startGame(PlayGroundState playGroundState,int playerID);
    public abstract void loadDeck();
    public abstract void playCard(int originIndex,int targetIndex);
    public abstract void attack(int originIndex,int targetIndex);
    public abstract void endTurn();


}

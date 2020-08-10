package server.logic.util;

import server.logic.gameState.PlayGroundState;

public class PlayGroundHandler {
    private int playerID;
    private PlayGroundState playGroundState;

    public PlayGroundHandler(int playerID, PlayGroundState playGroundState) {
        this.playerID = playerID;
        this.playGroundState = playGroundState;
    }
}

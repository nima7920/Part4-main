package server.logic.gameState;

import server.logic.engine.ResponseHandler;

public class PlayGroundState {
    private ResponseHandler responder1,responder2;

    public PlayGroundState(ResponseHandler responder1, ResponseHandler responder2) {
        this.responder1 = responder1;
        this.responder2 = responder2;
    }
}

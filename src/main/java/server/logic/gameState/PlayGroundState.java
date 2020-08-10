package server.logic.gameState;

import server.models.cards.Card;

public class PlayGroundState {

    private int currentPlayerID = 0;
    private GamerState gamer1, gamer2;
    private GamerMinionState[] ground1, ground2;

    public PlayGroundState() {

    }

    public int getCurrentPlayerID() {
        return currentPlayerID;
    }

    public void setCurrentPlayerID(int currentPlayerID) {
        this.currentPlayerID = currentPlayerID;
    }


public GamerState getGamer(int id){
        if(id==0){
            return gamer1;
        }else{
            return gamer2;
        }
}

public void setGamer(GamerState gamer,int id){
        if(id==0){
            gamer1=gamer;
        }else{
            gamer2=gamer;
        }
}


    public GamerMinionState[] getGround(int id) {
        if(id==0) {
            return ground1;
        }else {
            return ground2;
        }
    }

    public void setGround(GamerMinionState[] ground,int id) {
        if(id==0) {
            this.ground1 = ground;
        }else{
            this.ground2=ground;
        }
    }
}

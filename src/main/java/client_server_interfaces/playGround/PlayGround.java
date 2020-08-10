package client_server_interfaces.playGround;

import com.google.gson.annotations.Expose;

public class PlayGround {
    @Expose
    private int playerID;
    @Expose
    private Gamer gamer1;
    @Expose
    private Gamer gamer2;
    @Expose
    private GamerMinion[] ground1;
    @Expose
    private GamerMinion[] ground2;

    public int getCurrentPlayerID() {
        return playerID;
    }

    public void setCurrentPlayerID(int playerID) {
        this.playerID = playerID;
    }


    public Gamer getGamer(int id){
        if(id==0){
            return gamer1;
        }else{
            return gamer2;
        }
    }

    public void setGamer(Gamer gamer,int id){
        if(id==0){
            gamer1=gamer;
        }else{
            gamer2=gamer;
        }
    }


    public GamerMinion[] getGround(int id) {
        if(id==0) {
            return ground1;
        }else {
            return ground2;
        }
    }

    public void setGround(GamerMinion[] ground,int id) {
        if(id==0) {
            this.ground1 = ground;
        }else{
            this.ground2=ground;
        }
    }
}

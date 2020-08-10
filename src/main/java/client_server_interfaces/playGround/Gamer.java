package client_server_interfaces.playGround;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Gamer {
   @Expose
    private int mana = 1, turnNumber = 1;
   @Expose
   private GamerHero gamerHero = null;
    @Expose
    private GamerHeroPower gamerHeroPower = null;
    @Expose
    private int deckCards;
    @Expose
    private String[] handCards;
    @Expose
    private boolean discoverMode = false;
    @Expose
    private String[] discoveredCards;

    public Gamer() {

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public GamerHero getGamerHero() {
        return gamerHero;
    }

    public void setGamerHero(GamerHero gamerHero) {
        this.gamerHero = gamerHero;
    }

    public GamerHeroPower getGamerHeroPower() {
        return gamerHeroPower;
    }

    public void setGamerHeroPower(GamerHeroPower gamerHeroPower) {
        this.gamerHeroPower = gamerHeroPower;
    }

    public int getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(int deckCards) {
        this.deckCards = deckCards;
    }

    public String[] getHandCards() {
        return handCards;
    }

    public void setHandCards(String[] handCards) {
        this.handCards = handCards;
    }

    public boolean isDiscoverMode() {
        return discoverMode;
    }

    public void setDiscoverMode(boolean discoverMode) {
        this.discoverMode = discoverMode;
    }

    public String[] getDiscoveredCards() {
        return discoveredCards;
    }

    public void setDiscoveredCards(String[] discoveredCards) {
        this.discoveredCards = discoveredCards;
    }
}

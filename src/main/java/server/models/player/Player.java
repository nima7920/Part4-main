package server.models.player;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Player {

    @Id
    private String name;
@Column
    private String password;
@Column
    private long id;
@Column
    private int gems;
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "Decks")
    private ArrayList<Deck> decks=new ArrayList<>();

    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Deck currentDeck;
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private ArrayList<String> ownedCardsName=new ArrayList<>();

    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Logs logs;

    public Player() {

    }
// this constructor is for create account
    public Player(String name, String password, long id, int gems) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.gems = gems;
        this.decks=new ArrayList<>();
        this.ownedCardsName=new ArrayList<>();
        this.logs=new Logs(this.name+"-"+this.id);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public Deck getCurrentDeck() {
        return currentDeck;
    }

    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }

    public ArrayList<String> getOwnedCardsName() {
        return ownedCardsName;
    }

    public void setOwnedCardsName(ArrayList<String> ownedCardsName) {
        this.ownedCardsName = ownedCardsName;
    }

    public Logs getLogs() {
        return logs;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }
}

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

    private Deck currentDeck;
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private ArrayList<String> ownedCardsName=new ArrayList<>();

    public Player() {

    }
}

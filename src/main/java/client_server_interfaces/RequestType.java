package client_server_interfaces;

public enum RequestType {
   // login requests
    login_login, login_signUp, login_delete,
    // main requests
    backToMain, exitGame,
    main_play,main_store,main_collections,main_status,
   // store requests
    store_buyPanel , store_sellPanel ,store_cardSelect, store_buyCard , store_sellCard,
// collections requests
    collections_allCards,collections_gotoStore,collections_deckPanel,collections_selectDeck,
    collections_deckDeleteCard , collections_gotoCreate , collections_createDeck , collections_deleteDeck,
    collections_gotoAddCard , collections_deckAddCard , collections_changeName , collections_setCurrent;

}

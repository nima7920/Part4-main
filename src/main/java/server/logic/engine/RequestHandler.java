package server.logic.engine;

import client_server_interfaces.Request;

import java.util.HashMap;

public class RequestHandler {

    private GsonHandler gsonHandler;
    private static Engine engine;

    public RequestHandler(ResponseHandler responseHandler) {
        this.engine = new Engine(responseHandler);
        gsonHandler = new GsonHandler();
    }

    public void handleRequest(String requestString) {
        Request request = gsonHandler.deserializeRequest(requestString);
        if (request != null) {
            RequestTypeServer requestTypeServer = RequestTypeServer.valueOf(request.getRequestType().toString());
            requestTypeServer.execute(request.getParameters());
        }
    }

    private enum RequestTypeServer implements Executor {
        login_login {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.login(parameters);
            }
        }, login_signUp {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.signUp(parameters);
            }
        }, login_delete {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.deleteAccount(parameters);
            }
        }, main_play {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.gotoPlay();
            }
        },
        main_store {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.gotoStore();
            }
        },
        main_collections {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.gotoCollections();
            }
        },
        main_status {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.gotoStatus();
            }
        }, backToMain {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.backToMain();
            }
        }, exitGame {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.exitGame();
            }
        },
        store_buyPanel {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.sendBuyableCards();
            }
        }, store_sellPanel {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.sendSalableCards();
            }
        }, store_cardSelect {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.selectCardForBuySell(parameters);
            }
        }, store_buyCard {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.buyCard(parameters);
            }
        }, store_sellCard {
            @Override
            public void execute(HashMap<String, String> parameters) {
                engine.sellCard(parameters);
            }
        } , collections_allCards {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        },collections_gotoStore {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        },collections_deckPanel {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        },collections_selectDeck {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        },
        collections_deckDeleteCard {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_gotoCreate {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_createDeck {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_deleteDeck {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        },
        collections_gotoAddCard {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_deckAddCard {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_changeName {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, collections_setCurrent {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, preparation_playMode {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }, preparation_passive {
            @Override
            public void execute(HashMap<String, String> parameters) {

            }
        }
    }
}

package server.logic.engine;

import java.util.HashMap;

public interface Executor {
    void execute(HashMap<String,String> parameters);
}

package server.logic.engine;

import client_server_interfaces.Request;
import client_server_interfaces.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHandler {
    private GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();

    public String serializeResponse(Response response) {
        Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        String responseString = gson.toJson(response);
        return responseString;
    }

    public Request deserializeRequest(String requestString) {
        System.out.println(requestString);

        Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        Request request = gson.fromJson(requestString, Request.class);
        return request;
    }
}

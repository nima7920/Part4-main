package client.controller;

import client_server_interfaces.Request;
import client_server_interfaces.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHandler {
    private GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();

    public String serializeRequest(Request request) {
        Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String requestString = gson.toJson(request);
        return requestString;
    }

    public Response deserializeResponse(String responseString) {

        return null;
    }
}

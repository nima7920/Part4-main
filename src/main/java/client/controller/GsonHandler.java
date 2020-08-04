package client.controller;

import client_server_interfaces.Request;
import client_server_interfaces.Response;
import com.google.gson.GsonBuilder;

public class GsonHandler {
    private GsonBuilder gsonBuilder=new GsonBuilder().excludeFieldsWithoutExposeAnnotation();

    public String serializeRequest(Request request){

        return null;
    }

    public Response deserializeResponse(String responseString){

        return null;
    }
}

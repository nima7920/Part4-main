package client_server_interfaces;

import com.google.gson.annotations.Expose;

import java.util.HashMap;

public class Request {

    @Expose
    private String authToken;
    @Expose
    private RequestType requestType;
    @Expose
    private HashMap<String,String> parameters;

    public Request(String authToken, RequestType requestType, HashMap<String, String> parameters) {
        this.authToken = authToken;
        this.requestType = requestType;
        this.parameters = parameters;
    }

    public String getAuthToken() {
        return authToken;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }
}

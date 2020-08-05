package client_server_interfaces;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.HashMap;

public class Response {

    @Expose
    private RequestType requestType;
    @Expose
    private int resultCode = 0;
    @Expose
    private ArrayList<String> namesList;
    @Expose
    private HashMap<String, String> parameters;

    public Response() {
namesList=new ArrayList<>();
parameters=new HashMap<>();
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<String> namesList) {
        this.namesList = namesList;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}

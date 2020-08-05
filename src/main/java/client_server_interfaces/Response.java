package client_server_interfaces;

import com.google.gson.annotations.Expose;

public class Response {

    @Expose
    private RequestType requestType;
    @Expose
    private int resultCode=0;

    public Response(){

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
}

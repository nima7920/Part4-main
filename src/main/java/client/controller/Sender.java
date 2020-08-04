package client.controller;

import java.io.PrintWriter;

public class Sender {

    private PrintWriter out;
    private static Sender sender;

    public static Sender getInstance() {
        if (sender == null)
            sender = new Sender();
        return sender;
    }

    private Sender() {

    }

    void setOut(PrintWriter out){
        this.out=out;
    }
}

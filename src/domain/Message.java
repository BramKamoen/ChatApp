/*package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String message;
    private String tijd;
    private String sender;

    public Message(String text, String sender){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        this.setTijd(dateFormat.format(date));
        this.setMessage(text);
        this.setSender(sender);
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public String toString(){
        String respons = "";
        respons += this.sender + " - ";
        respons += this.message + " - ";
        respons += this.tijd;
        return respons;
    }
}*/
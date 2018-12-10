/*package domain;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Message> messageList;
    private String naam;

    public History(String naam){
        messageList = new ArrayList<Message>();
        this.setNaam(naam);
    }

    public List<Message> getMessageList() {
        return messageList;
    }
    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
    public void addMessage(Message message){
        this.messageList.add(message);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String toString(){
        String respons = "";
        for(Message m : messageList){
            respons += m.toString() + "\n";
        }
        return respons;
    }
}
*/
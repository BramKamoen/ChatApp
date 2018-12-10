/*package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.History;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MessageLijst extends AsynHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String anderepersoon = request.getParameter("id");

        List<History> berichten = person.getHistory();
        List<Message>responsberichten = null;
        for(History h: berichten){
            if(h.getNaam().equals(anderepersoon)){
                responsberichten = h.getMessageList();
            }
        }
        String Json = this.toJSON(responsberichten);
        System.out.println(Json);
        return Json;
        //List<String> messages = person.getHistory().g;
        //String Json = this.toJSON(vriendjes);

        //return Json;
    }
    public String toJSON (List<Message> vriendjes) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(vriendjes);
    }
}
*/
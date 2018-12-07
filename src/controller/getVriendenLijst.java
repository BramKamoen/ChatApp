package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class getVriendenLijst extends AsynHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        List<Person> vriendjes = person.getVrienden();
        String Json = this.toJSON(vriendjes);
        System.out.println(Json);

        return Json;
    }
    public String toJSON (List<Person> vriendjes) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(vriendjes);
    }
}
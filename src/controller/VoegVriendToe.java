package controller;

import domain.History;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class VoegVriendToe extends AsynHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String nieuweVriend = (String) request.getParameter("nieuweVriend");
        List<Person> lijst = service.getPersons();
        for (Person p: lijst
        ) {
            if(p.getUserId().equals(nieuweVriend)){
                person.addVriend(p);
                p.addVriend(person);
                service.updatePersons(person);
                service.updatePersons(p);
            }

        }

        return nieuweVriend;
    }
}
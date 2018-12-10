/*package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.History;
import domain.Message;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Messages extends AsynHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        PersonService service = super.getPersonService();
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String anderevriend = (String) request.getParameter("anderevriend");
        System.out.println(anderevriend);
        String bericht = (String) request.getParameter("bericht");
        List<Person> lijst = service.getPersons();
        System.out.println(lijst);
        System.out.println(bericht);


        Person anderepersoon = service.getPerson(anderevriend);


        Message berichtt = new Message(bericht, person.getFirstName());
        List<History> anderehistories = anderepersoon.getHistory();
        // System.out.println(person.getFirstName());
        //System.out.println(berichtt.toString());
        List<History> eigenhistories = person.getHistory();
        for (History h:
                eigenhistories) {
            if(h.getNaam().equals(anderevriend)){
                h.addMessage(berichtt);
                person.setHistory(eigenhistories);
                //System.out.println(h.toString());
            }
        }

        for (History x: anderehistories){
            if(x.getNaam().equals(person.getUserId())){
                x.addMessage(berichtt);
                anderepersoon.setHistory(anderehistories);
                System.out.println(anderepersoon.getFirstName() + " " + x.toString());
            }
        }
        return null;
    }
}
*/
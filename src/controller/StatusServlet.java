package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StatusServlet extends AsynHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService service = super.getPersonService();

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String status = (String) request.getParameter("status");
        person.setStatus(status);
        service.updatePersons(person);
        return status;
    }
}

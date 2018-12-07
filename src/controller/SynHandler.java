package controller;

import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SynHandler extends RequestHandler {
    private PersonService personService = super.getPersonService();

    @Override
    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel (PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
        Person person = (Person) request.getSession().getAttribute("user");
        if (person != null && person.getRole().equals(role)) {
            return true;
        }
        return false;
    }



}

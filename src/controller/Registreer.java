package controller;

import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Registreer extends SynHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService service = super.getPersonService();
        Person person = new Person();
        String destination = "index.jsp";
        List<String> errors = new ArrayList<>();

        verwerkGeslacht(person, request, errors);
        verwerkLeeftijd(person, request, errors);
        verwerkMail(person, request, errors);
        verwerkNaam(person, request, errors);
        verwerkVoorNaam(person, request, errors);
        verwerkPassword(person, request, errors);
        verwerkUserId(person, request, errors);
        verwerkRole(person, request, errors);

        person.setStatus("online");
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
        }
        else {
            service.addPerson(person);
            System.out.println(service.getPersons());
        }
        return destination;
    }
    public void verwerkVoorNaam(Person person, HttpServletRequest request, List<String> errors){
        try{
            String voornaam = request.getParameter("voornaam");
            person.setFirstName(voornaam);
        }
        catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkUserId(Person person, HttpServletRequest request, List<String> errors){
        try{
            String voornaam = request.getParameter("voornaam");
            person.setUserId(voornaam + "@ucll.be");
        }
        catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkNaam(Person person, HttpServletRequest request, List<String> errors){
        try{
            String naam = request.getParameter("naam");
            person.setLastName(naam);
        }
        catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkMail(Person person, HttpServletRequest request, List<String> errors){
        try{
            String mail = request.getParameter("mail");
            person.setEmail(mail);
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkGeslacht(Person person, HttpServletRequest request, List<String> errors){
        try{
            String geslacht = request.getParameter("geslacht");
            person.setGeslacht(geslacht);
        }
        catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkLeeftijd(Person person, HttpServletRequest request, List<String> errors){
        try {
            int leeftijd = Integer.parseInt(request.getParameter("leeftijd"));
            person.setLeeftijd(leeftijd);
        }
        catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkPassword(Person person, HttpServletRequest request, List<String> errors){
        try{
            String password = request.getParameter("password");
            String repassword =request.getParameter("repassword");
            if(password.equals(repassword)){
                person.setHashedPassword(password);
            }
            else {
                errors.add("De 2 wachtwoorden zijn niet hetzelfde");
            }
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }
    public void verwerkRole(Person person, HttpServletRequest request, List<String> errors){
        try {
            //String rol = request.getParameter("role").toUpperCase();
            String rol = "lid";
            Role role;

            if (rol.equals("ADMIN")) {
                role = Role.ADMIN;
            } else if (rol.equals("BIB")) {
                role = Role.BIB;
            } else {
                role = Role.LID;
            }
            person.setRole(role);
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }
}
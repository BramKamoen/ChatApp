package controller;

import db.DbException;
import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AddPerson extends SynHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> fouten = new ArrayList<>();
        PersonService service = super.getPersonService();

        String rol = request.getParameter("role").toUpperCase();
        Role role;

        if (rol.equals("ADMIN")) {
            role = Role.ADMIN;
        } else if (rol.equals("BIB")) {
            role = Role.BIB;
        }
        else {
            role = Role.LID;
        }

        Person p = new Person(request.getParameter("firstName") + "@ucll.be", request.getParameter("password"), request.getParameter("firstName"), request.getParameter("lastName"), role, request.getParameter("mail"), Integer.parseInt(request.getParameter("leeftijd")));


        try{
            service.addPerson(p);
        }catch (DbException e){
            fouten.add(e.getMessage());
        }
        if(fouten.size() == 0){
            return "index.jsp";

        }else{
            request.setAttribute("fouten",fouten);
            return "index.jsp";
        }
    }
}



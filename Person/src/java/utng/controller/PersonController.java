/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.PersonDAO;
import utng.dao.PersonDAOImp;
import utng.model.Person;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "PersonController", urlPatterns = {"/PersonController"})
public class PersonController extends HttpServlet {

    private static final String LISTA_PERSONS= "/listarPersons.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/persons.jsp";
    private PersonDAO dao;
    
    public PersonController() {
        dao = new PersonDAOImp();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_PERSONS;
            int p_uuid = Integer.parseInt(request.getParameter("p_uuid"));
            dao.borrarPerson(p_uuid);
            request.setAttribute("persons", dao.desplegarPerson());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int p_uuid = Integer.parseInt(request.getParameter("p_uuid"));
            Person person = dao.elegirPerson(p_uuid);
            request.setAttribute("person", person);///---------------------------------------------------------------------------
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_PERSONS;
            request.setAttribute("persons", dao.desplegarPerson());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Person person = new Person();
        String p_uuid = request.getParameter("pUuid");
        person.setLastSeen(request.getParameter("lastSeen")); 
        person.setLastClothing(request.getParameter("lastClothing"));
        person.setComments(request.getParameter("comments"));       
        if (p_uuid == null || p_uuid.isEmpty()) {
            dao.agregarPerson(person);
        } else {
            person.setpUuid(Integer.parseInt(p_uuid));
            dao.cambiarPerson(person);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_PERSONS);
        request.setAttribute("persons", dao.desplegarPerson());
        view.forward(request, response);
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

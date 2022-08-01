package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.entity.ListProfessors;
import com.stefanini.onlinecatalog.entity.Professors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ServletProfessors", value = "/ServletProfessors")
public class ServletProfessors extends HttpServlet {
    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();
        ListProfessors listProfessors = new ListProfessors();
        List<Professors> all;

        String filter = request.getParameter("filter");
        if (filter != null) {
            all = daoProfessor.getAllFiltered(filter);
        } else {
            all = daoProfessor.getAll();
        }
        Collections.sort(all, (o1, o2) -> o1.getID().compareTo(o2.getID()));
        listProfessors.setProfessorsList(all);
        request.setAttribute("listProfessors", listProfessors);

        daoProfessor.closeEntityManager();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/professors.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();

        if (request.getParameter("delete") != null) {
            doDelete(request, response);
        } else if (request.getParameter("id") != null) {
            doPut(request, response);
        } else {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            Professors professor = new Professors(firstName, lastName, email);
            daoProfessor.save(professor);

            daoProfessor.closeEntityManager();
            response.sendRedirect("ServletProfessors");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();

        Professors p = (Professors) daoProfessor.get(Integer.valueOf(request.getParameter("id"))).orElse(null);
        p.setFirstName(request.getParameter("firstName"));
        p.setLastName(request.getParameter("lastName"));
        p.setEmail(request.getParameter("email"));
        daoProfessor.update(p);

        daoProfessor.closeEntityManager();
        response.sendRedirect("ServletProfessors");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();

        Professors p = (Professors) daoProfessor.get(Integer.valueOf(request.getParameter("id"))).orElse(null);
        daoProfessor.delete(p);

        daoProfessor.closeEntityManager();
        response.sendRedirect("ServletProfessors");
    }

    public void destroy() {
    }
}

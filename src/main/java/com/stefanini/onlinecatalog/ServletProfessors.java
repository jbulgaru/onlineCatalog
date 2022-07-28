package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.entity.ListProfessors;
import com.stefanini.onlinecatalog.entity.Professors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProfessors", value = "/ServletProfessors")
public class ServletProfessors extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListProfessors listProfessors = new ListProfessors();
        DaoProfessor daoProfessor = new DaoProfessor();

        List<Professors> all = daoProfessor.getAll();
        listProfessors.setProfessorsList(all);
        request.setAttribute("listProfessors", listProfessors);

        daoProfessor.closeEntityManager();

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/professors.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Professors professor = new Professors(firstName, lastName, email);
        daoProfessor.save(professor);

        daoProfessor.closeEntityManager();

        response.sendRedirect("ServletProfessors");
    }

    public void destroy() {
    }
}

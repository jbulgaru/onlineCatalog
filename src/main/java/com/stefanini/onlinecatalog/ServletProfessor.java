package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessors;
import com.stefanini.onlinecatalog.entity.Professors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProfessor", value = "/ServletProfessor")
public class ServletProfessor extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n\n\tMy Servlet verification\n\n");
        DaoProfessors daoProfessors = new DaoProfessors();
        Professors professor = (Professors) daoProfessors.get(21).orElse(null);
        PrintWriter sw = response.getWriter();
        System.out.println("\n" + professor);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}

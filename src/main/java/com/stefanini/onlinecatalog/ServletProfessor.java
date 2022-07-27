package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.dao.DaoSubject;
import com.stefanini.onlinecatalog.entity.Professors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletProfessor", value = "/ServletProfessor")
public class ServletProfessor extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();
        DaoSubject daoSubject = new DaoSubject();
        try {
//            Professors p = (Professors) daoProfessor.get(25).orElse(null);
//            daoProfessor.delete(p);

            daoSubject.getAll().forEach(System.out::println);

        } finally {
            daoProfessor.closeEntityManager();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}

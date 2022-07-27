package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessor;
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
        DaoProfessor daoProfessor = new DaoProfessor();
//        PrintWriter sw = response.getWriter();
//
//        daoProfessor.getAll().forEach(System.out::println);
//
//        Professors p = (Professors) daoProfessor.get(22).orElse(null);
//        p.setEmail("vitalieparaskiv@gmail.com");
//        daoProfessor.update(p);

        daoProfessor.getAll().forEach(System.out::println);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}

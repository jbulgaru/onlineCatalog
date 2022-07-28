package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoSubject;
import com.stefanini.onlinecatalog.entity.Subjects;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCourses", value = "/ServletCourses")
public class ServletCourses extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSubject daoSubject = new DaoSubject();
        try {
            List<Subjects> coursesList = daoSubject.getAll();
            request.setAttribute("courses", coursesList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/courses.jsp");
            dispatcher.forward(request, response);

        } finally {
            daoSubject.closeEntityManager();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}

package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoSubject;
import com.stefanini.onlinecatalog.entity.ListCourses;
import com.stefanini.onlinecatalog.entity.Professors;
import com.stefanini.onlinecatalog.entity.Subjects;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ServletCourses", value = "/ServletCourses")
public class ServletCourses extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSubject daoSubject = new DaoSubject();
        ListCourses listCourses = new ListCourses();
        List<Subjects> all;

        String filter = request.getParameter("filter");
        if (filter != null) {
            all = daoSubject.getAllFiltered(filter);
        } else {
            all = daoSubject.getAll();
        }
        Collections.sort(all, Comparator.comparing(Subjects::getID));
        listCourses.setCoursesList(all);
        request.setAttribute("listCourses", listCourses);

        daoSubject.closeEntityManager();

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/courses.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSubject daoSubject = new DaoSubject();

        if (request.getParameter("delete") != null) {
            doDelete(request, response);
        } else if (request.getParameter("id") != null) {
            doPut(request, response);
        } else {
            String name = request.getParameter("name");
            Integer classroom = Integer.valueOf(request.getParameter("classroom"));
            Subjects course = new Subjects(name, classroom);
            daoSubject.save(course);

            daoSubject.closeEntityManager();
            response.sendRedirect("ServletCourses");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSubject daoSubject = new DaoSubject();

        Subjects course = (Subjects) daoSubject.get(Integer.valueOf(request.getParameter("id"))).orElse(null);
        course.setName(request.getParameter("name"));
        course.setRoom(Integer.valueOf(request.getParameter("classroom")));
        daoSubject.update(course);

        daoSubject.closeEntityManager();
        response.sendRedirect("ServletCourses");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSubject daoSubject = new DaoSubject();

        Subjects p = (Subjects) daoSubject.get(Integer.valueOf(request.getParameter("id"))).orElse(null);
        daoSubject.delete(p);

        daoSubject.closeEntityManager();
        response.sendRedirect("ServletCourses");
    }

    public void destroy() {
    }
}

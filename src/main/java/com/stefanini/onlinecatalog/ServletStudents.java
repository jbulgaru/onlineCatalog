package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoStudent;
import com.stefanini.onlinecatalog.entity.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletStudents", value = "/ServletStudents")
public class ServletStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoStudent daoStudent = new DaoStudent();
        Students student = new Students("olea", "sdfsdf", "sdfa@com", "n");
        student.setID(1);
        daoStudent.delete(student);
//        daoStudent.close();
        PrintWriter writer = response.getWriter();
        /*List<Students> listStudents = daoStudent.getAll();

        writer.println("<html>");
        writer.println("<head>");
        for (int i = 0; i < listStudents.size(); i++) {
            writer.println("<h>");
            writer.println(listStudents.get(i).toString());
            writer.println("<br>");
            writer.println("</h>");
        }
        writer.println("</head>");
        writer.println("</html>");*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

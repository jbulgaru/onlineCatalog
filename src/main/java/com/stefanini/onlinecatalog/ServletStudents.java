package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.dao.DaoStudent;
import com.stefanini.onlinecatalog.entity.Students;
import org.hibernate.annotations.NamedQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ServletStudents", value = "/ServletStudents")
public class ServletStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoStudent daoStudent = new DaoStudent();
        daoStudent.getBursieriDeMerit();
        daoStudent.getGrantHolders();
        List<Students> studentsList = daoStudent.getAll();
        daoStudent.close();
        //daoStudent.close();
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        for (int i = 0; i < studentsList.size(); i++) {
            writer.println("<h>");
            writer.println(studentsList.get(i).toString());
            writer.println("<br>");
            writer.println("</h>");
        }
        writer.println("</head>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

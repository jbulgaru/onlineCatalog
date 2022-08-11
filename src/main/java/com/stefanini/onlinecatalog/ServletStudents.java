package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/students.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("update");
        if(method != null){
            doPut(request, response);
        } else if (request.getParameter("delete") != null) {
            doDelete(request, response);
        } else if (request.getParameter("newStudent") != null) {
            DaoStudent daoStudent = new DaoStudent();
            Students student = new Students();
            student.setGrantHolder(request.getParameter("GrantHolder"));
            student.setFirstName(request.getParameter("FirstName"));
            student.setLastName(request.getParameter("LastName"));
            student.setEmail(request.getParameter("Email"));
            try{
                daoStudent.save(student);
            }catch (Exception e){
                e.printStackTrace();
            }
            response.sendRedirect("ServletStudents");
        }
    }
    @Override
    protected  void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        DaoStudent daoStudent = new DaoStudent();
        DaoProf_Stud_Subj daoProfStudSubj = new DaoProf_Stud_Subj();
        Students student = daoStudent.find(Integer.valueOf(request.getParameter("delete")));
        Integer idStudent = student.getID();
        try{
            //daoProfStudSubj.deleteStudentsByIDs(idStudent);
            daoStudent.delete(student);
        }catch (Exception e){
            System.out.println("\n\nConstraint error when trying to remove student entity!!!\n\n\n");
            e.printStackTrace();
        }

        daoStudent.close();
        response.sendRedirect("ServletStudents");

    }
    @Override
    protected  void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DaoStudent daoStudent = new DaoStudent();
        Students student = daoStudent.find(Integer.valueOf(request.getParameter("update")));
        student.setFirstName(request.getParameter("FirstName"));
        student.setLastName(request.getParameter("LastName"));
        student.setEmail(request.getParameter("Email"));
        student.setGrantHolder(request.getParameter("GrantHolder"));
        try{
            daoStudent.update(student);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("ServletStudents");
    }
}

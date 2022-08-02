package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj;
import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.dao.DaoStudent;
import com.stefanini.onlinecatalog.dao.DaoSubject;
import com.stefanini.onlinecatalog.entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ServletProf_Stud_Subj", value = "/ServletProf_Stud_Subj")
public class ServletProf_Stud_Subj extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*//How to save an grade object into DB
        if(prof_stud_subj != null){
            daoProf_stud_subj.save(prof_stud_subj);
        }
        else {
            System.out.println("Object is NULL and can not be persist");
        }*/

       /* //Set an existing ID for grade to be deleted
        prof_stud_subj.setID(59);
        daoProf_stud_subj.delete(prof_stud_subj);
        System.out.println("Deleted");*/

       /* //find a grade by id
       Prof_Stud_Subj prof_stud_subj1 = daoProf_stud_subj.find(60);
        System.out.println(prof_stud_subj1 + "\nfinded");*/

       /* //Update a grade
        prof_stud_subj.setID(62);
        prof_stud_subj.setGrade(8.8f);
        daoProf_stud_subj.update(prof_stud_subj);*/


        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Prof_stud_subj.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
        String param = request.getParameter("delete");

        if (request.getParameter("newGrade") != null) {
            Prof_Stud_Subj profStudSubj=null;
            Integer subj = Integer.parseInt(request.getParameter("SubjectID"));
            Integer stud = Integer.parseInt(request.getParameter("StudentID"));
            Integer prof = Integer.parseInt(request.getParameter("ProfessorID"));
            String grade = request.getParameter("Grade");
            profStudSubj = daoProf_stud_subj.ifExist(subj, stud, prof, Float.parseFloat(grade));
            if (profStudSubj != null) {
                daoProf_stud_subj.save(profStudSubj);
            } else {
                System.out.println("Object is NULL and can not be persist");
            }
            response.sendRedirect("ServletProf_Stud_Subj");
        } else if (param != null) {
            doDelete(request, response);
        }
        else if (request.getParameter("update") != null) {
            doPut( request,  response);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
        Prof_Stud_Subj p =  daoProf_stud_subj.find(Integer.valueOf(request.getParameter("delete")));
        daoProf_stud_subj.delete(p);
        daoProf_stud_subj.close();
        response.sendRedirect("ServletProf_Stud_Subj");
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
        DaoProfessor daoProfessor= new DaoProfessor();
        DaoStudent daoStudent = new DaoStudent();
        DaoSubject daoSubject = new DaoSubject();
        Prof_Stud_Subj profStudSubj;
        try{
            profStudSubj = daoProf_stud_subj.find(Integer.valueOf(request.getParameter("update")));
            Professors professor = daoProfessor.find(Integer.valueOf(request.getParameter("ProfessorID")));
            Subjects subject = daoSubject.find(Integer.valueOf(request.getParameter("SubjectID")));
            Students student = daoStudent.find(Integer.valueOf(request.getParameter("StudentID")));

            profStudSubj.setProfessorID(professor);
            profStudSubj.setStudentID(student);
            profStudSubj.setSubjectID(subject);
            profStudSubj.setGrade(Float.parseFloat(request.getParameter("Grade")));

            daoProf_stud_subj.update(profStudSubj);
            daoProf_stud_subj.close();

        }
        catch (Exception e){
            System.out.println("\n\nError when trying to update grade!!!\n\n");
            e.printStackTrace();
        }

        response.sendRedirect("ServletProf_Stud_Subj");
    }
}


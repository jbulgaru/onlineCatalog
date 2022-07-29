package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj;
import com.stefanini.onlinecatalog.entity.Prof_Stud_Subj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProf_Stud_Subj", value = "/ServletProf_Stud_Subj")
public class ServletProf_Stud_Subj extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
        Prof_Stud_Subj prof_stud_subj = daoProf_stud_subj.ifExist();

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


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");

            writer.println("<h>inserted!!!");


            writer.println("<br>");
            writer.println("</h>");

        writer.println("</head>");
        writer.println("</html>");
daoProf_stud_subj.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

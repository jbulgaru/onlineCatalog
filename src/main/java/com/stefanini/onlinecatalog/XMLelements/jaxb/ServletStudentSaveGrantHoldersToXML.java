package com.stefanini.onlinecatalog.XMLelements.jaxb;

import com.stefanini.onlinecatalog.XMLelements.*;
import com.stefanini.onlinecatalog.activemq.MessageSender;
import com.stefanini.onlinecatalog.activemq.ReadXML;
import com.stefanini.onlinecatalog.dao.DaoStudent;

import javax.jms.JMSException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet( name = "ServletStudentSaveGrantHoldersToXML", value = "/ServletStudentSaveGrantHoldersToXML")
public class ServletStudentSaveGrantHoldersToXML extends HttpServlet {
    static String path = "C:\\Users\\YBULHARU\\IdeaProjects\\OnlineCatalog\\src\\main\\resources\\XMLfileStudents.xml";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/students.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

         if(req.getParameter("save").equals("grantHolders")){
           try {
               this.saveGrantHoldersToXML();
               this.sendToActivemq("StudentsGrantHolders");
            } catch (JAXBException | JMSException e) {
               throw new RuntimeException(e);
           }
        }
         else if(req.getParameter("save").equals("genius")){
             try{
                 this.saveGrantHoldersGeniusToXML();
                 this.sendToActivemq("StudentsGrantHoldersPro");
             }catch (JAXBException | JMSException e) {
                 throw new RuntimeException(e);
             }
         }
        resp.sendRedirect("ServletStudents");
    }

    public void sendToActivemq(String queueNmae) throws JMSException, JAXBException {
        ReadXML readXML = new ReadXML(path);
        String file =  readXML.readXMLfileByLine();
        MessageSender messageSender = new MessageSender(queueNmae, file);
        messageSender.start();
        messageSender.send();
        messageSender.close();
    }

    public void saveGrantHoldersToXML() throws JAXBException {
        DaoStudent daoStudent = new DaoStudent();
        Marshall marshall = new Marshall();
        File file = new File(path);
        Element element = new Element();
        List<com.stefanini.onlinecatalog.entity.Students> JPAStudentList = daoStudent.getAllGrantHolders();
        List<Students> JAXBstudentsList = new ArrayList<>();
        for (int i = 0; i < JPAStudentList.size(); i++) {
            JAXBstudentsList.add(new Students(JPAStudentList.get(i)));
        }
        element.setStudents(JAXBstudentsList);
        marshall.marshall(element, file);

    }
    public void saveGrantHoldersGeniusToXML() throws JAXBException {
        DaoStudent daoStudent = new DaoStudent();
        Marshall marshall = new Marshall();
        File file = new File(path);
        Element element = new Element();
        List<com.stefanini.onlinecatalog.entity.Students> JPAStudentList = daoStudent.getBursieriDeMerit();
        List<Students> JAXBstudentsList = new ArrayList<>();
        for (int i = 0; i < JPAStudentList.size(); i++) {
            JAXBstudentsList.add(new Students(JPAStudentList.get(i)));
        }
        element.setStudents(JAXBstudentsList);
        marshall.marshall(element, file);

    }
}

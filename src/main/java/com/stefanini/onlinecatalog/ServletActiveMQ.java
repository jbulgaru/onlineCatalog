package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.XMLelements.XMLProfessor;
import com.stefanini.onlinecatalog.XMLelements.jaxb.Marshall;
import com.stefanini.onlinecatalog.activemq.MessageSender;
import com.stefanini.onlinecatalog.dao.DaoProfessor;
import com.stefanini.onlinecatalog.entity.Professors;

import javax.jms.JMSException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;


@WebServlet(name = "ServletActiveMQ", value = "/ServletActiveMQ")
public class ServletActiveMQ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProfessor daoProfessor = new DaoProfessor();

        String id = request.getParameter("ID");
        Professors p = (Professors) daoProfessor.get(Integer.valueOf(id)).orElse(null);
        XMLProfessor xmlProfessor = new XMLProfessor(p);
        String queueName = "professor";

        try {
            String stringObject = new Marshall().marshallToString(xmlProfessor);

            MessageSender messageSender = new MessageSender(queueName, stringObject);
            messageSender.start();
            messageSender.send();
            messageSender.close();

            response.sendRedirect("/OnlineCatalog");

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

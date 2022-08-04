package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.XMLelements.jaxb.Marshall;
import com.stefanini.onlinecatalog.activemq.MessageSender;
import com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj;
import com.stefanini.onlinecatalog.entity.Prof_Stud_Subj;

import javax.jms.JMSException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCatalogWithGradesLessThenFiveActiveMQ", value = "/ServletCatalogWithGradesLessThenFiveActiveMQ")
public class ServletCatalogWithGradesLessThenFiveActiveMQ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoProf_Stud_Subj daoProfStudSubj = new DaoProf_Stud_Subj();
        StringBuilder stringBuilder = new StringBuilder();
        Marshall marshall = new Marshall();
        MessageSender messageSender;

        List<Prof_Stud_Subj> catalogWithGradesLessThenFive = daoProfStudSubj.catalogWithGradesLessThenFive();
        daoProfStudSubj.close();

        for (Prof_Stud_Subj c : catalogWithGradesLessThenFive) {
            try {
                String stringObject = marshall.marshallToString(
                        new com.stefanini.onlinecatalog.XMLelements.Prof_Stud_Subj(c));
                stringBuilder.append(stringObject);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            messageSender = new MessageSender("catalogWithGradesLessThenFive", stringBuilder.toString());
            messageSender.start();
            messageSender.send();
            messageSender.close();

            response.sendRedirect("/OnlineCatalog");

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

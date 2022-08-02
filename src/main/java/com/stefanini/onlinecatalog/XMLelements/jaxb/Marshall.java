package com.stefanini.onlinecatalog.XMLelements.jaxb;

import com.stefanini.onlinecatalog.XMLelements.Prof_Stud_Subj;
import com.stefanini.onlinecatalog.XMLelements.Professors;
import com.stefanini.onlinecatalog.XMLelements.Students;
import com.stefanini.onlinecatalog.XMLelements.Subjects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Marshall {
    public void marshall(Object obj, File file) throws JAXBException {
        try{
            JAXBContext context = JAXBContext.newInstance(Subjects.class, Students.class, Prof_Stud_Subj.class, Professors.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, file);
        }catch (JAXBException e){
            System.out.println("Err: ");
            e.printStackTrace();
        }
    }
    public static Object unmarshall(File file) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Subjects.class, Students.class, Prof_Stud_Subj.class, Professors.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

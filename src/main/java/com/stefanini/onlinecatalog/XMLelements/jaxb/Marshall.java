package com.stefanini.onlinecatalog.XMLelements.jaxb;

import com.stefanini.onlinecatalog.XMLelements.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
public class Marshall {
    public void marshall(Object obj, File file) throws JAXBException {
        try{
            JAXBContext context = JAXBContext.newInstance(Subjects.class, Students.class, Prof_Stud_Subj.class, Professors.class, Element.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, file);

        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
    public static Element unmarshall(File file) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Subjects.class, Students.class, Prof_Stud_Subj.class, Professors.class, Element.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Element)unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

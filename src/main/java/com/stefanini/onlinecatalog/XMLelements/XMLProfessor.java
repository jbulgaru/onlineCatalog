package com.stefanini.onlinecatalog.XMLelements;

import com.stefanini.onlinecatalog.entity.Professors;

import javax.xml.bind.annotation.*;


@XmlRootElement(name ="professor")
@XmlType(name = "xml_professor", propOrder = {"ID","firstName", "lastName", "email" })
@XmlAccessorType(XmlAccessType.NONE)
public class XMLProfessor {

    Integer ID;

    String firstName;

    String lastName;

    String email;

    public XMLProfessor() {
    }

    public XMLProfessor(Professors p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        this.ID = p.getID();
    }

    public Integer getID() {
        return ID;
    }
    @XmlAttribute(name = "id")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement(name = "Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor {" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

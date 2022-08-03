package com.stefanini.onlinecatalog.XMLelements;


import javax.xml.bind.annotation.*;

@XmlRootElement(name ="Student")
@XmlType(name = "student", propOrder = {"ID","firstName", "lastName", "email", "grantHolder" })
@XmlAccessorType (XmlAccessType.NONE)
public class Students {

    int ID;
    String firstName;
    String lastName;
    String email;
    String grantHolder;

    public Students() {}

    public Students(Integer id, String firstName, String lastName,
                    String email, String grantHolder) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grantHolder = grantHolder;
    }
    public Students(com.stefanini.onlinecatalog.entity.Students student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.grantHolder = student.getGrantHolder();
        this.ID = student.getID();
    }

    public int getID() {return ID;}
    @XmlAttribute(name = "id")
    public void setID(int ID) {this.ID = ID;}
    public String getFirstName() {return firstName;}
    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    @XmlElement(name = "email")
    public void setEmail(String email) {this.email = email;}
    public String getGrantHolder() {return grantHolder;}
    @XmlElement(name = "grantHolder")
    public void setGrantHolder(String grantHolder) {this.grantHolder = grantHolder;}

    @Override
    public String toString() {
        return "Students{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", grantHolder=" + grantHolder +
                '}';
    }
}

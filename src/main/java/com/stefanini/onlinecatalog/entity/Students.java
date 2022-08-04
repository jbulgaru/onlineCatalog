package com.stefanini.onlinecatalog.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.*;




     /*@NamedQuery(name = "find student by ID", query = "select s from Students s")
     @NamedQuery(name = "find student by min grade", query = "select s from Students s")
     @NamedQuery(name = "group students by professors", query = "select s from Students s")
     @NamedQuery(name = "group students by subjects", query = "select s from Students s group by ")*/

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer ID;
    @Column(name = "FirstName", length = 48, nullable = false)
    String firstName;
    @Column(name = "LastName", length = 48, nullable = false)
    String lastName;
    @Column(name = "Email", length = 82)
    String email;
    @Column(name = "GrantHolder", length = 1)
    String grantHolder;

    public Students() {}

    public Students(String firstName, String lastName,
                    String email, String grantHolder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grantHolder = grantHolder;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public Integer getID() {return ID;}
    public void setID(Integer ID) {this.ID = ID;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getGrantHolder() {return grantHolder;}
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

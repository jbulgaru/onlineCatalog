package com.stefanini.onlinecatalog.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class Professors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer ID;

    @NotNull
    @Column(name = "FirstName", length = 48)
    String firstName ;

    @NotNull
    @Column(name = "LastName", length = 48)
    String lastName ;

    @Column(name = "email", length = 82)
    String email;

    public Professors() {}

    public Professors(String firstName,
                      String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professors{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

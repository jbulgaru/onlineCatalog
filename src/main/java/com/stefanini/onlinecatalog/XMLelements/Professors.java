package com.stefanini.onlinecatalog.XMLelements;



public class Professors {

    Integer ID;

    String firstName;

    String lastName;

    String email;

    public Professors() {
    }

    public Professors(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Professors(com.stefanini.onlinecatalog.entity.Professors professor) {
        this.firstName = professor.getFirstName();
        this.lastName = professor.getLastName();
        this.email = professor.getEmail();
        this.ID = professor.getID();
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
        return "Professor {" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

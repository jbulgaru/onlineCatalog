package com.stefanini.onlinecatalog.XMLelements;






public class Students {

    Integer ID;

    String firstName;

    String lastName;

    String email;

    String grantHolder;

    public Students() {}

    public Students(String firstName, String lastName,
                    String email, String grantHolder) {
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

package com.stefanini.onlinecatalog.XMLelements;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grade")
public class Prof_Stud_Subj {

    Integer ID;
    Students studentID;
    Professors professorID;
    Subjects subjectID;
    Float grade;


    public Prof_Stud_Subj() {}

    public Prof_Stud_Subj(Students studentID, Professors professorID, Subjects subjectID, Float grade) {
        this.studentID = studentID;
        this.professorID = professorID;
        this.subjectID = subjectID;
        this.grade = grade;
    }
    public Prof_Stud_Subj(com.stefanini.onlinecatalog.entity.Prof_Stud_Subj profStudSubj) {
        this.studentID = new Students(profStudSubj.getStudentID());
        this.professorID = new Professors(profStudSubj.getProfessorID());
        this.subjectID = new Subjects(profStudSubj.getSubjectID());
        this.grade = profStudSubj.getGrade();
    }
    public Integer getID() {
        return ID;
    }
@XmlAttribute(name = "ID")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Students getStudentID() {
        return studentID;
    }
    @XmlElement
    public void setStudentID(Students studentID) {
        this.studentID = studentID;
    }

    public Professors getProfessorID() {
        return professorID;
    }
    @XmlElement
    public void setProfessorID(Professors professorID) {
        this.professorID = professorID;
    }
    public Subjects getSubjectID() {
        return subjectID;
    }
    @XmlElement
    public void setSubjectID(Subjects subjectID) {
        this.subjectID = subjectID;
    }

    public Float getGrade() {
        return grade;
    }
    @XmlElement
    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Prof_Stud_Subj{" +
                "ID=" + ID +
                ", studentID=" + studentID +
                ", professorID=" + professorID +
                ", subjectID=" + subjectID +
                ", grade=" + grade +
                '}';
    }
}

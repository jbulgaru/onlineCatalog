package com.stefanini.onlinecatalog.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Prof_Stud_Subj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer ID;

    @ManyToOne(targetEntity = Students.class)
    @JoinColumn(name = "StudentID", referencedColumnName = "ID", nullable = false)
    Students studentID;

    @ManyToOne(targetEntity = Professors.class)
    @JoinColumn(name = "ProfessorID", referencedColumnName = "ID", nullable = false)
    Professors professorID;

    @ManyToOne(targetEntity = Subjects.class)
   @JoinColumn(name = "SubjectID", referencedColumnName = "ID", nullable = false)
    Subjects subjectID;

    @Column(name = "Grade", nullable = false)
    Float grade;


    public Prof_Stud_Subj() {}

    public Prof_Stud_Subj(Students studentID, Professors professorID, Subjects subjectID, Float grade) {
        this.studentID = studentID;
        this.professorID = professorID;
        this.subjectID = subjectID;
        this.grade = grade;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Students getStudentID() {
        return studentID;
    }

    public void setStudentID(Students studentID) {
        this.studentID = studentID;
    }

    public Professors getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Professors professorID) {
        this.professorID = professorID;
    }

    public Subjects getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subjects subjectID) {
        this.subjectID = subjectID;
    }

    public Float getGrade() {
        return grade;
    }

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

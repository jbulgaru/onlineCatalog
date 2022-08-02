package com.stefanini.onlinecatalog.XMLelements;

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

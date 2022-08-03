package com.stefanini.onlinecatalog.XMLelements;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Element {
    List<Students> students = new ArrayList<>();
    List<Subjects> subjects = new ArrayList<>();
    List<Prof_Stud_Subj> profStudSubjs = new ArrayList<>();
    List<Professors> professors = new ArrayList<>();

    public Element() {}

    public Element(List<Students> students, List<Subjects> subjects,
                   List<Prof_Stud_Subj> profStudSubjs, List<Professors> professors) {
        this.students = students;
        this.subjects = subjects;
        this.profStudSubjs = profStudSubjs;
        this.professors = professors;
    }

    @XmlElement
    public void setStudents(List<Students> students) {
        this.students = students;
    }
    @XmlElement
    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
    @XmlElement
    public void setProfStudSubjs(List<Prof_Stud_Subj> profStudSubjs) {
        this.profStudSubjs = profStudSubjs;
    }
    @XmlElement
    public void setProfessors(List<Professors> professors) {
        this.professors = professors;
    }

    public List<Students> getStudents() {
        return students;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public List<Prof_Stud_Subj> getProfStudSubjs() {
        return profStudSubjs;
    }

    public List<Professors> getProfessors() {
        return professors;
    }
}

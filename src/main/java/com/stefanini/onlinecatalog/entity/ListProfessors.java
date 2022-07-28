package com.stefanini.onlinecatalog.entity;

import java.util.ArrayList;
import java.util.List;

public class ListProfessors {
    private List<Professors> professorsList = new ArrayList<>();

    public List<Professors> getProfessorsList() {
        return professorsList;
    }

    public void setProfessorsList(List<Professors> professorsList) {
        this.professorsList = professorsList;
    }

    public int getSize() {
        return this.getProfessorsList().size();
    }
}

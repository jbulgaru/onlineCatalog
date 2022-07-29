package com.stefanini.onlinecatalog.entity;

import java.util.ArrayList;
import java.util.List;

public class ListCourses {
    private List<Subjects> coursesList = new ArrayList<>();

    public List<Subjects> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Subjects> coursesList) {
        this.coursesList = coursesList;
    }
    public int getSize() {
        return this.getCoursesList().size();
    }
}

package com.stefanini.onlinecatalog.XMLelements;


public class Subjects {
    Integer ID;
    String name;
    Integer room;

    public Subjects() {
    }

    public Subjects(String name, Integer room) {
        this.name = name;
        this.room = room;
    }
    public Subjects(com.stefanini.onlinecatalog.entity.Subjects subject) {
        this.name = subject.getName();
        this.room = subject.getRoom();
        this.ID = subject.getID();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", room=" + room +
                '}';
    }
}

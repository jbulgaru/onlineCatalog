package com.stefanini.onlinecatalog.entity;

import javax.persistence.*;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer ID;
    @Column(name = "Name", length = 48, nullable = false)
    String name;
    @Column(name = "Room", nullable = false)
    Integer room;

    public Subjects() {
    }

    public Subjects(String name, Integer room) {
        this.name = name;
        this.room = room;
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

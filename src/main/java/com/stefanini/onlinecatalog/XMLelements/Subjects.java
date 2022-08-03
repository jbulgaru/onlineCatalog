package com.stefanini.onlinecatalog.XMLelements;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="subject")
@XmlType(name = "subject", propOrder = {"ID","name", "room" })
@XmlAccessorType(XmlAccessType.NONE)
public class Subjects {

    Integer ID;

    String name;

    Integer room;
    public Subjects() {
    }

    public Subjects(Integer id, String name, Integer room) {
        this.ID = id;
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
    @XmlAttribute(name = "id")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }
    @XmlElement(name = "classroom")
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

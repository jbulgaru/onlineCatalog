package com.stefanini.onlinecatalog.entity;

import javax.persistence.*;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer ID;



}

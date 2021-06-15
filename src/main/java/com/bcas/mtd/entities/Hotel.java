package com.bcas.mtd.entities;

import javax.persistence.*;

@Entity
@Table
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;

}

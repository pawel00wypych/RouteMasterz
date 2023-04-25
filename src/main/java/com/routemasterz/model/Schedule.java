package com.routemasterz.model;

import jakarta.persistence.*;


@Entity
@Table(
        name = "schedule"
)
public class Schedule {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    public Schedule() {
    }
    public Schedule(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

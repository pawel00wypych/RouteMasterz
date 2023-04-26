package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "route_date"
)
public class RouteDate {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    @Column(
            nullable = false
    )
    private String date;

    public RouteDate() {
    }
    public RouteDate(String date) {
        this.date = date;
    }
    public RouteDate(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

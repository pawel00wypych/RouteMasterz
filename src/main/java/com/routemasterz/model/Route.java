package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "route"
)
public class Route {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            name="created_at",
            nullable = false
    )
    private String createdAt;

    public Route() {
    }
    public Route(String name, String createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
    public Route(int id, String name, String createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

package com.routemasterz.model;

import jakarta.persistence.*;
import com.routemasterz.model.Checkpoint;
import java.util.List;
import java.util.Set;

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
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            name="created_at",
            nullable = false
    )
    private String createdAt;


    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Checkpoint> checkpoints;

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

package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "route"
)
public class Route {

    @Id
    @SequenceGenerator(
            name = "user_details_id_seq",
            sequenceName = "user_details_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_id_seq"
    )
    private int id;
    @Column(
            name="creator_id",
            nullable = false
    )
    private int creatorId;
    private String name;
    @Column(
            name="created_at"
    )
    private String createdAt;

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
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

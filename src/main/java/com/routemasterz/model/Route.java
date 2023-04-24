package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "route",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "route_name_unique",
                        columnNames = "name"
                )
        }
)
public class Route {

    @Id
    @SequenceGenerator(
            name = "route_id_seq",
            sequenceName = "route_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "route_id_seq"
    )
    private int id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id", referencedColumnName = "id")
    private UserEntity creatorId;
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
    public Route(UserEntity creatorId, String name, String createdAt) {
        this.creatorId = creatorId;
        this.name = name;
        this.createdAt = createdAt;
    }
    public Route(int id, UserEntity creatorId, String name, String createdAt) {
        this.id = id;
        this.creatorId = creatorId;
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

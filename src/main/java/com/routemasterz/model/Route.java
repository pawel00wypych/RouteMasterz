package com.routemasterz.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "route"
)
public class Route {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistician_id")
    private UserEntity logistician;

    public Route() {
    }
    public Route(String name, String createdAt, UserEntity logistician) {
        this.name = name;
        this.createdAt = createdAt;
        this.logistician = logistician;
    }
    public Route(Long id, String name, String createdAt, UserEntity logistician) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.logistician = logistician;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getLogistician() {
        return logistician;
    }

    public void setLogistician(UserEntity logistician) {
        this.logistician = logistician;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", logistician=" + logistician +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(getId(), route.getId()) && Objects.equals(getName(), route.getName()) && Objects.equals(getCreatedAt(), route.getCreatedAt()) && Objects.equals(getLogistician(), route.getLogistician());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreatedAt(), getLogistician());
    }
}

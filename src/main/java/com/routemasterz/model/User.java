package com.routemasterz.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "my_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_email_unique",
                        columnNames = "email"
                )
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "my_user_id_seq",
            sequenceName = "my_user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "my_user_id_seq"
    )
    private long id;

    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(
            nullable = false
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;

    private LocalDate createdAt;

    public User() {
    }

    public User( Role role,
                 String email,
                 String password,
                 LocalDate createdAt) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public User(long id,
                Role role,
                String email,
                String password,
                LocalDate createdAt) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

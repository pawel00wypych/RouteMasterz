package com.routemasterz.model;

import jakarta.persistence.*;


@Entity
@Table(
        name = "schedule"
)
public class Schedule {

    @Id
    @SequenceGenerator(
            name = "schedule_id_seq",
            sequenceName = "schedule_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_id_seq"
    )
    private int id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "my_user_id", referencedColumnName = "id")
    private User user;

    public Schedule() {
    }
    public Schedule(User user) {
        this.user = user;
    }
    public Schedule(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

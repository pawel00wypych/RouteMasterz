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
    private UserEntity userEntity;

    public Schedule() {
    }
    public Schedule(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    public Schedule(int id, UserEntity userEntity) {
        this.id = id;
        this.userEntity = userEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}

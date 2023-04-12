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

    @Column(
            name="user_id",
            nullable = false
    )
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

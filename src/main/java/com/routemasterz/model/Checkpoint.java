package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "checkpoint"
)
public class Checkpoint {

    @Id
    @SequenceGenerator(
            name = "checkpoint_id_seq",
            sequenceName = "checkpoint_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "checkpoint_id_seq"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
    private String location;
    private int order;
    private String hour;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}

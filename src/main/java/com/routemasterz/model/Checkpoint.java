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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
    private String location;

    @Column(
            name="checkpoint_order"
    )
    private int checkpointOrder;
    private String hour;

    public Checkpoint() {
    }
    public Checkpoint( Route route, String location, int checkpointOrder, String hour) {
        this.route = route;
        this.location = location;
        this.checkpointOrder = checkpointOrder;
        this.hour = hour;
    }
    public Checkpoint(int id, Route route, String location, int checkpointOrder, String hour) {
        this.id = id;
        this.route = route;
        this.location = location;
        this.checkpointOrder = checkpointOrder;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCheckpointOrder() {
        return checkpointOrder;
    }

    public void setCheckpointOrder(int checkpointOrder) {
        this.checkpointOrder = checkpointOrder;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}

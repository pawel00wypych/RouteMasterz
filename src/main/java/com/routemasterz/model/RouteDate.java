package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "route_date"
)
public class RouteDate {

    @Id
    @SequenceGenerator(
            name = "route_date_id_seq",
            sequenceName = "route_date_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "route_date_id_seq"
    )
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="schedule_id", referencedColumnName = "id")
    private Schedule scheduleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route routeId;
    @Column(
            nullable = false
    )
    private String date;

    public RouteDate() {
    }
    public RouteDate( Schedule scheduleId, Route routeId, String date) {
        this.scheduleId = scheduleId;
        this.routeId = routeId;
        this.date = date;
    }
    public RouteDate(int id, Schedule scheduleId, Route routeId, String date) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.routeId = routeId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

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

    @Column(
            name="schedule_id"
    )
    private int scheduleId;
    @Column(
            name="route_id"
    )
    private int routeId;
    private String date;
}

package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "truck",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "truck_unique",
                        columnNames = "user_id"
                )
        }
)
public class Truck {

    @Id
    @SequenceGenerator(
            name = "truck_id_seq",
            sequenceName = "truck_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "truck_id_seq"
    )
    private int id;
    @Column(
            name="user_id",
            nullable = false
    )
    private int userId;
    private String name;
    private int payloadCapacity;
    private String engine;
    private int fuelTank;
    private int fuelUsage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(int payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public int getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(int fuelUsage) {
        this.fuelUsage = fuelUsage;
    }
}

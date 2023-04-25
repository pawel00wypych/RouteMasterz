package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "truck"
)
public class Truck {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String name;
    private int payloadCapacity;
    private String engine;
    private int fuelTank;
    private int fuelUsage;

    public Truck() {
    }
    public Truck(String name, int payloadCapacity, String engine, int fuelTank, int fuelUsage) {
        this.name = name;
        this.payloadCapacity = payloadCapacity;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.fuelUsage = fuelUsage;
    }
    public Truck(int id, String name, int payloadCapacity, String engine, int fuelTank, int fuelUsage) {
        this.id = id;
        this.name = name;
        this.payloadCapacity = payloadCapacity;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.fuelUsage = fuelUsage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

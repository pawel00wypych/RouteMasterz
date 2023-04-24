package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "truck",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "truck_my_user_id_unique",
                        columnNames = "my_user_id"
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
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="my_user_id", referencedColumnName = "id")
    private UserEntity userEntityId;
    private String name;
    private int payloadCapacity;
    private String engine;
    private int fuelTank;
    private int fuelUsage;

    public Truck() {
    }
    public Truck(UserEntity userEntityId, String name, int payloadCapacity, String engine, int fuelTank, int fuelUsage) {
        this.userEntityId = userEntityId;
        this.name = name;
        this.payloadCapacity = payloadCapacity;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.fuelUsage = fuelUsage;
    }
    public Truck(int id, UserEntity userEntityId, String name, int payloadCapacity, String engine, int fuelTank, int fuelUsage) {
        this.id = id;
        this.userEntityId = userEntityId;
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

    public UserEntity getUserId() {
        return userEntityId;
    }

    public void setUserId(UserEntity userEntityId) {
        this.userEntityId = userEntityId;
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

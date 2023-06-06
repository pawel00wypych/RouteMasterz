package com.routemasterz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "checkpoint"
)
public class Checkpoint {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    @JsonBackReference
    private Route route;

    private String country;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String hour;

    @Column(
            name="checkpoint_order"
    )
    private int checkpointOrder;

    public Checkpoint() {
    }

    public Checkpoint(Long id, Route route, String country, String street, String city, String state, String postalcode, String hour, int checkpointOrder) {
        this.id = id;
        this.route = route;
        this.country = country;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.hour = hour;
        this.checkpointOrder = checkpointOrder;
    }

    public Checkpoint(Route route, String country, String street, String city, String state, String postalcode, String hour, int checkpointOrder) {
        this.route = route;
        this.country = country;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.hour = hour;
        this.checkpointOrder = checkpointOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
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

    @Override
    public String toString() {
        return "Checkpoint{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", hour='" + hour + '\'' +
                ", checkpointOrder=" + checkpointOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkpoint that = (Checkpoint) o;
        return getCheckpointOrder() == that.getCheckpointOrder() && Objects.equals(getId(), that.getId()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getPostalcode(), that.getPostalcode()) && Objects.equals(getHour(), that.getHour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getStreet(), getCity(), getState(), getPostalcode(), getHour(), getCheckpointOrder());
    }
}

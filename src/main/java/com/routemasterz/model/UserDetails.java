package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "user_details",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "my_user_id_unique",
                        columnNames = "my_user_id"
                )
        }
)
public class UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_details_id_seq",
            sequenceName = "user_details_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_id_seq"
    )
    private int id;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "my_user_id", referencedColumnName = "id")
    private User user;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private String surname;
    @Column(
            nullable = false
    )
    private String residence;
    @Column(
            nullable = false
    )
    private String company;
    private int phoneNumber;
    private String profilePhotoSource;
    @Column(
            nullable = false
    )
    private String createdAt;

    public UserDetails() {
    }

    public UserDetails(
                       User user,
                       String name,
                       String surname,
                       String residence,
                       String company,
                       int phoneNumber,
                       String profilePhotoSource,
                       String createdAt) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.residence = residence;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.profilePhotoSource = profilePhotoSource;
        this.createdAt = createdAt;
    }

    public UserDetails(int id,
                       User user,
                       String name,
                       String surname,
                       String residence,
                       String company,
                       int phoneNumber,
                       String profilePhotoSource,
                       String createdAt) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.residence = residence;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.profilePhotoSource = profilePhotoSource;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePhotoSource() {
        return profilePhotoSource;
    }

    public void setProfilePhotoSource(String profilePhotoSource) {
        this.profilePhotoSource = profilePhotoSource;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

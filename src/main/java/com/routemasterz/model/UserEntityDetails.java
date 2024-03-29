package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "user_details"
)
public class UserEntityDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @OneToOne(mappedBy = "userEntityDetails",fetch = FetchType.EAGER)
    private UserEntity userEntity;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private String surname;
    private String residence;
    private String company;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "profile_photo")
    private String profilePhotoSource;
    @Column(name = "created_at")
    private String createdAt;

    public UserEntityDetails() {
    }

    public UserEntityDetails(
                       String name,
                       String surname,
                       String residence,
                       String company,
                       int phoneNumber,
                       String profilePhotoSource,
                       String createdAt) {
        this.name = name;
        this.surname = surname;
        this.residence = residence;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.profilePhotoSource = profilePhotoSource;
        this.createdAt = createdAt;
    }

    public UserEntityDetails(int id,
                             String name,
                             String surname,
                             String residence,
                             String company,
                             int phoneNumber,
                             String profilePhotoSource,
                             String createdAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.residence = residence;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.profilePhotoSource = profilePhotoSource;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
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

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
public class UserEntityDetails {

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
    private UserEntity userEntity;
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

    public UserEntityDetails() {
    }

    public UserEntityDetails(
                       UserEntity userEntity,
                       String name,
                       String surname,
                       String residence,
                       String company,
                       int phoneNumber,
                       String profilePhotoSource,
                       String createdAt) {
        this.userEntity = userEntity;
        this.name = name;
        this.surname = surname;
        this.residence = residence;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.profilePhotoSource = profilePhotoSource;
        this.createdAt = createdAt;
    }

    public UserEntityDetails(int id,
                             UserEntity userEntity,
                             String name,
                             String surname,
                             String residence,
                             String company,
                             int phoneNumber,
                             String profilePhotoSource,
                             String createdAt) {
        this.id = id;
        this.userEntity = userEntity;
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

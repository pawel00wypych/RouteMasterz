package com.routemasterz.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "user_details",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_id_user_unique",
                        columnNames = "id_user"
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
    @OneToOne
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
    private String residence;
    @Column(
            nullable = false
    )
    private String company;
    private int phoneNumber;
    private String profilePhotoSource;
    private String createdAt;
}

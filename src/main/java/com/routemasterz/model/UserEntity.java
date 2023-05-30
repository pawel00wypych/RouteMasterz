package com.routemasterz.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(
        name = "my_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "my_user_email_unique",
                        columnNames = "email"
                )
        }
)
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(
            nullable = false
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;
    @Column(
            nullable = false
    )
    private String createdAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntityDetails userEntityDetails;

    public UserEntity() {
    }

    public UserEntity(Role role,
                      String email,
                      String password,
                      String createdAt,
                      UserEntityDetails userEntityDetails) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.userEntityDetails = userEntityDetails;
    }

    public UserEntity(long id,
                      Role role,
                      String email,
                      String password,
                      String createdAt) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntityDetails getUserEntityDetails() {
        return userEntityDetails;
    }

    public void setUserEntityDetails(UserEntityDetails userEntityDetails) {
        this.userEntityDetails = userEntityDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return getId() == that.getId() && getRole() == that.getRole() && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUserEntityDetails(), that.getUserEntityDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRole(), getEmail(), getPassword(), getCreatedAt(), getUserEntityDetails());
    }
}

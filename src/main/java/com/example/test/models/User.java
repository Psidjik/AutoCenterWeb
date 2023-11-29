package com.example.test.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private List<Offer> offers;
    private UserRole role;
    private boolean is_active;
    private String firstName;
    private String imageUrl;
    private String last_name;
    private String password;
    private String username;

    public User(LocalDateTime modified, LocalDateTime created, UserRole role, boolean is_active, String firstName, String imageUrl,
                String last_name, String password, String username) {
        super(modified, created);
        this.role = role;
        this.is_active = is_active;
        this.firstName = firstName;
        this.imageUrl = imageUrl;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
    }

    public User() {
    }
    @Transient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    @Column(name = "is_active", nullable = false)
    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column(name = "last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package com.example.test.models;

import com.example.test.models.enums.Role;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class UserRole {
    protected String id;
    private Role role;
    private List<User> user;

    public UserRole(Role role) {
        this.role = role;
    }
    public UserRole() {
    }
    @Column(name = "name")
    @Enumerated(value = EnumType.ORDINAL)
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }

}
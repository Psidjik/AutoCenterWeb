package com.example.test.dtos.views;

import com.example.test.models.Offer;
import com.example.test.models.UserRole;

import java.util.List;

public class UserViewModel {
    private String username;
    private String firstName;
    private String last_name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}

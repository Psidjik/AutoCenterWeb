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
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;

    List<Model> models;

    public Brand(LocalDateTime modified, LocalDateTime created, String name) {
        super(modified, created);
        this.name = name;
    }
    public Brand(){}

    @OneToMany(mappedBy = "brand")
    public List<Model> getModel() {
        return models;
    }

    public void setModel(List<Model> models) {
        this.models = models;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}

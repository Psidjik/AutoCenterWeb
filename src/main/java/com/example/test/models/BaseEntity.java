package com.example.test.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    private String id;
    private LocalDateTime modified;
    private LocalDateTime created;

    public BaseEntity() {
    }

    public BaseEntity(LocalDateTime modified, LocalDateTime created) {
        this.modified = modified;
        this.created = created;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", modified=" + modified +
                ", created=" + created +
                '}';
    }
}

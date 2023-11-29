package com.example.test.dtos;

import com.example.test.util.UniqueBrandName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.UUID;

public class BrandDto {


    @UniqueBrandName
    private String name;


    public BrandDto() {}

        public BrandDto(String name) {
        this.name = name;
    }


//    public LocalDateTime getModified() {
//        return modified;
//    }
//
//    public void setModified(LocalDateTime modified) {
//        this.modified = modified;
//    }
//
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, message = "name must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandDto{" +

//                ", modified=" + modified +
//                ", created=" + created +
                ", name='" + name + '\'' +
                '}';
    }
}

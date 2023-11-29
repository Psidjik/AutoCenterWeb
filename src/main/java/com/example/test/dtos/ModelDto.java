package com.example.test.dtos;



import com.example.test.models.enums.Category;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.UUID;

public class ModelDto{
    private Category category;
    private int endYear;
    private String imageUrl;
    private String name;
    private int startYear;
    private String brand;


    public ModelDto() {}

    public ModelDto(Category category,
                    int endYear, String imageUrl, String name, int startYear, String brand) {
        this.category = category;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
        this.name = name;
        this.startYear = startYear;
        this.brand = brand;
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
    @NotNull
    @Min(value = 1900, message = "date cannot be earlier than 1900")
    @Max(value = 2024, message = "date cannot be in the future")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    @NotBlank
    @NotEmpty(message = "The imageUrl cannot be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, message = "name must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Min(value = 1900, message = "start date cannot be earlier than 1900")
    @Max(value = 2024, message = "start date cannot be in the future")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                ", category=" + category +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", startYear=" + startYear +
                ", brand=" + brand +
                '}';
    }
}

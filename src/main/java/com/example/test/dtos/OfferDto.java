package com.example.test.dtos;

import com.example.test.models.enums.Engine;
import com.example.test.models.enums.Transmission;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.UUID;

public class OfferDto{
    private UUID id;
    private LocalDateTime modified;
    private LocalDateTime created;
    private ModelDto model;
    private UserDto user;
    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private double price;
    private Transmission transmission;
    private int years;

    public OfferDto() {
    }

    public OfferDto(LocalDateTime modified, LocalDateTime created, ModelDto model, UserDto user,
                    String description, Engine engine, String image_url, int mileage, double price, Transmission transmission, int years) {
        this.modified = modified;
        this.created = created;
        this.model = model;
        this.user = user;
        this.description = description;
        this.engine = engine;
        this.image_url = image_url;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.years = years;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
    @NotBlank
    @Length(min = 10, message = "Brand name must be more ten characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @NotNull
    @Min(value = 1, message = "The mileage cannot be less than 1")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    
    @NotNull
    @Min(value = 1900, message = "The release date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release date cannot be in the future")
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "id=" + id +
                ", modified=" + modified +
                ", created=" + created +
                ", model=" + model +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", image_url='" + image_url + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", years=" + years +
                '}';
    }
}

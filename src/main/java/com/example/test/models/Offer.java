package com.example.test.models;

import com.example.test.models.enums.Engine;
import com.example.test.models.enums.Transmission;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {


    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private double price;
    private Transmission transmission;
    private int years;

    private Model model;
    private User user;
    public Offer(LocalDateTime modified, LocalDateTime created, Model model, User user, String description,
                 Engine engine, String image_url, int mileage, double price, Transmission transmission, int years) {
        super(modified, created);

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
    public Offer(){}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "engine")
    @Enumerated(value = EnumType.ORDINAL)
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Column(name = "image_url")
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "transmission")
    @Enumerated(value = EnumType.ORDINAL)
    public Transmission getTransmission() {
        return transmission;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Column(name = "year")
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Offer{" +
                ", model=" + model +
                ", seller=" + user +
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
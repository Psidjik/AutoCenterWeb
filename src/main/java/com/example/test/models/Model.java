package com.example.test.models;

import com.example.test.models.enums.Category;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    private List<Offer> offers;
    private Brand brand;
    private Category category;
    private int endYear;
    private String imageUrl;
    private String name;
    private int startYear;

    public Model(LocalDateTime modified, LocalDateTime created, Brand brand, Category category, int endYear, String imageUrl, String name, int startYear) {
        super(modified, created);
        this.brand = brand;
        this.category = category;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
        this.name = name;
        this.startYear = startYear;
    }
    public Model(){}
    @Transient
    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    @Column(name = "category")
    @Enumerated(value = EnumType.ORDINAL)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "end_year")
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "start_year")
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Override
    public String toString() {
        return "Model{" +
                "offers=" + offers +
                ", brand=" + brand +
                ", category=" + category +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", startYear=" + startYear +
                '}';
    }
}

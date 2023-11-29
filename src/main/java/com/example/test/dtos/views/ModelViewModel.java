package com.example.test.dtos.views;

import com.example.test.models.enums.Category;

public class ModelViewModel {
    private String name;
    private Category category;
    private int endYear;
    private String imageUrl;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.example.test.dtos.views;

public class OfferViewModelForUser {
    private String id;
    private String model;
    private int mileage;
    private double price;
    private int years;


    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "OfferViewModel{" +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", years=" + years +
                '}';
    }
}

package com.example.test.models.enums;

public enum Transmission{
    MANUAL(0), AUTOMATIC(1);

    private int value;

    Transmission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

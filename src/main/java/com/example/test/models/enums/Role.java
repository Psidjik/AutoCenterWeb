package com.example.test.models.enums;

public enum Role {
    USER(0), CLIENT(1) ,ADMIN(2);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

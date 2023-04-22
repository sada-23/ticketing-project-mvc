package com.company.enums;

public enum Gender {

//    MALE, FEMALE;
    MALE("Male"),FEMALE("Female");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

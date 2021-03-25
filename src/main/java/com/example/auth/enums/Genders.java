package com.example.auth.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genders {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other"),
    NOT_SPECIFIED("Not Specified");

    @JsonProperty("label")
    String label;

    Genders(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

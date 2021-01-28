package com.example.auth.enums;

import java.util.Arrays;

public enum AccessLevels {
    ALL, READ, CREATE, UPDATE, DELETE;

    public static AccessLevels from(String name) {
        if (name == null) return null;
        return Arrays.stream(values())
                .filter(v -> v.toString().toUpperCase().equals(name.trim().toUpperCase()))
                .findFirst().orElse(null);
    }
}

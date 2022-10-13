package com.example.autodiploma;

import lombok.Data;

@Data
public class SpareParts {
    private final String id;
    private final String name;
    private final Type type;
    public enum Type{
        TRANSMISSION, ENGINE, STEERING, CHASSIS
    }
}

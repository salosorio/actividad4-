package com.example.demo.shared.domain;

import org.apache.commons.lang3.Validate;

public class Limit {
    private final Integer value;

    public Limit(int value) {
        Validate.notNull(value, "this can't be null");
        Validate.inclusiveBetween(1,100,value , "Limit should be between 1 and 100");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

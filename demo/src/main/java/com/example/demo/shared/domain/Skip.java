package com.example.demo.shared.domain;

import org.apache.commons.lang3.Validate;

//cuátos registros vamos a saltar cuando haga la consulta
public class Skip {
    private final Integer value;

    public Skip(int value) {
        Validate.notNull(value, "this can't be null");
        Validate.isTrue(value >= 0, "the number can't be negative ");// permite comparar que un # este dentro de un rango
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

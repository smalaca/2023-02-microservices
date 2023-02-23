package com.smalaca.purchase.command.domain.quantity;

public class QuantityValueObject {
    private final int value;

    private QuantityValueObject(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}

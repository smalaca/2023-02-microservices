package com.smalaca.purchase.command.domain.order;

import java.util.UUID;

class OrderNumberValueObject {
    private final String value;

    private OrderNumberValueObject(String value) {
        this.value = value;
    }

    static OrderNumberValueObject generate() {
        return new OrderNumberValueObject(UUID.randomUUID().toString());
    }
}

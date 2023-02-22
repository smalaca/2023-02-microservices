package com.smalaca.purchase.command.domain.order;

import java.util.UUID;

class OrderNumber {
    private final String value;

    private OrderNumber(String value) {
        this.value = value;
    }

    static OrderNumber generate() {
        return new OrderNumber(UUID.randomUUID().toString());
    }
}

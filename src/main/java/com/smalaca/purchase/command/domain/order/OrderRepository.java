package com.smalaca.purchase.command.domain.order;

import java.util.UUID;

public interface OrderRepository {
    OrderAggregateRoot findBy(UUID orderId);

    void save(OrderAggregateRoot order);
}

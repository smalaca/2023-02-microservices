package com.smalaca.purchase.command.domain.order;

import java.util.UUID;

public interface OrderRepository {
    Order findBy(UUID orderId);

    void save(Order order);
}

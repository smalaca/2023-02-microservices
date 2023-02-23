package com.smalaca.purchase.infrastructure.adapter.secondary.repository.order;

import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public OrderAggregateRoot findBy(UUID orderId) {
        return null;
    }

    @Override
    public void save(OrderAggregateRoot order) {

    }
}

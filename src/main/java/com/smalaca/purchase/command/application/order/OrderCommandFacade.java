package com.smalaca.purchase.command.application.order;

import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderRepository;
import com.smalaca.purchase.command.domain.order.PaymentMethodValueObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class OrderCommandFacade {
    private final OrderRepository orderRepository;

    public OrderCommandFacade(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void buyProducts(UUID orderId, String paymentMethod) {
        // tłumaczenie na język domenowy [0..*]
        OrderAggregateRoot order = orderRepository.findBy(orderId);
        PaymentMethodValueObject paymentMethodVO = PaymentMethodValueObject.from(paymentMethod);

        // jedna linijka kodu wywołująca domenę
        order.place(paymentMethodVO);

        // zapis agregatów [1..*]
        orderRepository.save(order);
    }
}

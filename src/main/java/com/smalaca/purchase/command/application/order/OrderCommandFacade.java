package com.smalaca.purchase.command.application.order;

import com.smalaca.purchase.command.domain.order.Order;
import com.smalaca.purchase.command.domain.order.OrderRepository;
import com.smalaca.purchase.command.domain.order.PaymentMethod;
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
        Order order = orderRepository.findBy(orderId);
        PaymentMethod paymentMethodVO = PaymentMethod.from(paymentMethod);

        // jedna linijka kodu wywołująca domęnę
        order.buyProducts(paymentMethodVO);

        // zapis agregatów [1..*]
        orderRepository.save(order);
    }
}

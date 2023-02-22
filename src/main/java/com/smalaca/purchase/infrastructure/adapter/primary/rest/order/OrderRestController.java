package com.smalaca.purchase.infrastructure.adapter.primary.rest.order;

import com.smalaca.purchase.command.application.order.OrderCommandFacade;
import com.smalaca.purchase.query.order.OrderQueryFacade;

import java.util.UUID;

public class OrderRestController {
    private final OrderCommandFacade orderCommandFacade;
    private final OrderQueryFacade orderQueryFacade;

    public OrderRestController(OrderCommandFacade orderCommandFacade, OrderQueryFacade orderQueryFacade) {
        this.orderCommandFacade = orderCommandFacade;
        this.orderQueryFacade = orderQueryFacade;
    }

    public void buyProducts(UUID orderId, String paymentMethod) {
        orderCommandFacade.buyProducts(orderId, paymentMethod);
    }
}

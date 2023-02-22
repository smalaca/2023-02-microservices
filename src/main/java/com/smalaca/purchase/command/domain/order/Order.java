package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.product.ProductVO;

import java.util.List;
import java.util.UUID;

// Aggregate root
public class Order {
    private UUID id;
    private OrderState state;
    private OrderNumber orderNumber;
    private List<ProductVO> productVOS;

    Order(OrderNumber orderNumber, OrderState orderState, List<ProductVO> productVOS) {
        this.orderNumber = orderNumber;
        this.state = orderState;
        this.productVOS = productVOS;
    }

    public void place(PaymentMethod paymentMethodVO) {
        state = OrderState.PLACED;
    }
}

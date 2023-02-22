package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;
import java.util.UUID;

// Aggregate root
public class OrderAggregateRoot {
    private UUID id;
    private OrderStateValueObject state;
    private OrderNumberValueObject orderNumber;
    private List<ProductValueObject> productVOS;

    OrderAggregateRoot(OrderNumberValueObject orderNumber, OrderStateValueObject orderState, List<ProductValueObject> productVOS) {
        this.orderNumber = orderNumber;
        this.state = orderState;
        this.productVOS = productVOS;
    }

    public void place(PaymentMethodValueObject paymentMethodVO) {
        state = OrderStateValueObject.PLACED;
    }
}

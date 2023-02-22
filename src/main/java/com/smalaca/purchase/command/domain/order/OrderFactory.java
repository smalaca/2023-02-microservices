package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OrderFactory {
    public static OrderAggregateRoot create(List<ProductValueObject> productVOS) {
        OrderNumberValueObject orderNumber = OrderNumberValueObject.generate();
        OrderStateValueObject orderState = OrderStateValueObject.CREATED;

        OrderAggregateRoot order = new OrderAggregateRoot(orderNumber, orderState, productVOS);
        return order;
    }
}

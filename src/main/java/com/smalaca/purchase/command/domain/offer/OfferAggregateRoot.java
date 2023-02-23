package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderFactory;
import com.smalaca.purchase.command.domain.order.ParameterObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OfferAggregateRoot {
    private List<ProductValueObject> productVOS;

    public OrderAggregateRoot accept(OrderFactory orderFactory, ParameterObject parameterObject) {
        return orderFactory.create(productVOS, parameterObject);
    }
}

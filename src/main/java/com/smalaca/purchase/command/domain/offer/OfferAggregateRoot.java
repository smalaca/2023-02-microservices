package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderBuilder;
import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OfferAggregateRoot {
    private List<ProductValueObject> productVOS;

    public OrderAggregateRoot accept(ParameterObject parameterObject) {
        PriceValueObject price = null;
        return OrderBuilder.order()
                .with(productVOS)
                .with(parameterObject.getAddress())
                .with(parameterObject.getDeliveryMethod())
                .withDiscountCode(parameterObject.getDiscountCode())
                .with(price)
                .build();
    }
}

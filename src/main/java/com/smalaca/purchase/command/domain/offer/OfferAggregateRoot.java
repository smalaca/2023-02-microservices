package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderBuilder;
import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OfferAggregateRoot {
    private List<ProductValueObject> productVOS;

    public OrderAggregateRoot accept(AddressValueObject address, DeliveryMethodValueObject deliveryMethod, String discountCode) {
        PriceValueObject price = null;
        return OrderBuilder.order()
                .with(productVOS)
                .with(address)
                .with(deliveryMethod)
                .withDiscountCode(discountCode)
                .with(price)
                .build();
    }
}

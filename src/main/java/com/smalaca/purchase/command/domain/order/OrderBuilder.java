package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OrderBuilder {
    private List<ProductValueObject> products;
    private AddressValueObject address;
    private DeliveryMethodValueObject deliveryMethod;
    private String discountCode;
    private PriceValueObject price;

    private OrderBuilder() {}

    public static OrderBuilder order() {
        return new OrderBuilder();
    }

    public OrderBuilder with(List<ProductValueObject> products) {
        this.products = products;
        return this;
    }

    public OrderBuilder with(AddressValueObject address) {
        this.address = address;
        return this;
    }

    public OrderBuilder with(DeliveryMethodValueObject deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        return this;
    }

    public OrderBuilder withDiscountCode(String discountCode) {
        this.discountCode = discountCode;
        return this;
    }

    public OrderBuilder with(PriceValueObject price) {
        this.price = price;
        return this;
    }

    public OrderAggregateRoot build() {
        OrderNumberValueObject orderNumber = OrderNumberValueObject.generate();
        OrderStateValueObject orderState = OrderStateValueObject.CREATED;

        return new OrderAggregateRoot(orderNumber, orderState, products);
    }
}

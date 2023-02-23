package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Entity
public class OrderAggregateRoot {
    @Id
    @GeneratedValue
    private UUID id;
    private List<ProductValueObject> products;
    private AddressValueObject address;
    private DeliveryMethodValueObject deliveryMethod;
    private String discountCode;
    private PriceValueObject price;
    private OrderNumberValueObject orderNumber;
    private OrderStateValueObject state;

    private OrderAggregateRoot(Builder builder) {
        products = builder.products;
        address = builder.address;
        deliveryMethod = builder.deliveryMethod;
        discountCode = builder.discountCode;
        price = builder.price;
        orderNumber = builder.orderNumber;
        state = builder.state;
    }

    public void place(PaymentMethodValueObject paymentMethodVO) {
        state = OrderStateValueObject.PLACED;
    }

    static class Builder {
        private List<ProductValueObject> products;
        private AddressValueObject address;
        private DeliveryMethodValueObject deliveryMethod;
        private String discountCode;
        private PriceValueObject price;
        private OrderNumberValueObject orderNumber;
        private OrderStateValueObject state;

        private Builder() {}

        static Builder order() {
            return new Builder();
        }

        Builder with(List<ProductValueObject> products) {
            this.products = products;
            return this;
        }

        Builder with(AddressValueObject address) {
            this.address = address;
            return this;
        }

        Builder with(DeliveryMethodValueObject deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        Builder withDiscountCode(String discountCode) {
            this.discountCode = discountCode;
            return this;
        }

        Builder with(PriceValueObject price) {
            this.price = price;
            return this;
        }

        Builder with(OrderNumberValueObject orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        Builder with(OrderStateValueObject state) {
            this.state = state;
            return this;
        }

        OrderAggregateRoot build() {
            return new OrderAggregateRoot(this);
        }
    }
}

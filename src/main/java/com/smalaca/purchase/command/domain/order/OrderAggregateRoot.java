package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

// Aggregate root
@Entity
public class OrderAggregateRoot {
    @Id
    @GeneratedValue
    private UUID id;
    private OrderStateValueObject state;
    private OrderNumberValueObject orderNumber;
    private List<ProductValueObject> productVOS;
    private AddressValueObject address;
    private DeliveryMethodValueObject deliveryMethod;
    private String discountCode;
    private PriceValueObject price;

    OrderAggregateRoot(OrderNumberValueObject orderNumber, OrderStateValueObject orderState, List<ProductValueObject> productVOS) {
        this.orderNumber = orderNumber;
        this.state = orderState;
        this.productVOS = productVOS;
    }

    public void place(PaymentMethodValueObject paymentMethodVO) {
        state = OrderStateValueObject.PLACED;
    }
}

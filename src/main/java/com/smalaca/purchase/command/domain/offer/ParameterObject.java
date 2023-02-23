package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import lombok.Getter;

@Getter
public class ParameterObject {
    private final AddressValueObject address;
    private final DeliveryMethodValueObject deliveryMethod;
    private final String discountCode;

    ParameterObject(AddressValueObject address, DeliveryMethodValueObject deliveryMethod, String discountCode) {
        this.address = address;
        this.deliveryMethod = deliveryMethod;
        this.discountCode = discountCode;
    }
}

package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import org.springframework.stereotype.Component;

@Component
public class ParameterObjectFactory {
    public ParameterObject create(AddressValueObject address, DeliveryMethodValueObject deliveryMethod, String discountCode) {
        return new ParameterObject(address, deliveryMethod, discountCode);
    }
}

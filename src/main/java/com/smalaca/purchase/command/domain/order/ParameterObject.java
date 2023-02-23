package com.smalaca.purchase.command.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParameterObject {
    private final AddressValueObject address;
    private final DeliveryMethodValueObject deliveryMethod;
    private final String discountCode;
}

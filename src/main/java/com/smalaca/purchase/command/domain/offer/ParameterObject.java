package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class ParameterObject {
    private final AddressValueObject address;
    private final DeliveryMethodValueObject deliveryMethod;
    private final String discountCode;
    private final DiscountService discountService;

    ParameterObject(
            AddressValueObject address, DeliveryMethodValueObject deliveryMethod, String discountCode,
            DiscountService discountService) {
        this.address = address;
        this.deliveryMethod = deliveryMethod;
        this.discountCode = discountCode;
        this.discountService = discountService;
    }

    AddressValueObject getAddress() {
        return address;
    }

    DeliveryMethodValueObject getDeliveryMethod() {
        return deliveryMethod;
    }

    String getDiscountCode() {
        return discountCode;
    }

    PriceValueObject getFinalPriceFor(List<ProductValueObject> products) {
        PriceValueObject finalPrice = products.stream()
                .map(ProductValueObject::getTotalPrice)
                .reduce(PriceValueObject.ZERO, PriceValueObject::add);

        if (discountCode != null) {
            return discountService.withDiscount(finalPrice, discountCode);
        }

        return finalPrice;
    }
}

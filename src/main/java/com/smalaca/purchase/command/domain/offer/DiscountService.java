package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.price.PriceValueObject;

public interface DiscountService {
    PriceValueObject withDiscount(PriceValueObject price, String discountCode);
}

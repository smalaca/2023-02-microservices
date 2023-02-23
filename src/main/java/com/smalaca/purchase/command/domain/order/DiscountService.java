package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.price.PriceValueObject;

public interface DiscountService {
    PriceValueObject withDiscount(PriceValueObject price, String discountCode);
}

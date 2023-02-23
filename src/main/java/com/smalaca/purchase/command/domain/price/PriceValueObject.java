package com.smalaca.purchase.command.domain.price;

import com.smalaca.purchase.command.domain.quantity.QuantityValueObject;

import java.math.BigDecimal;

public class PriceValueObject {
    public static final PriceValueObject ZERO = new PriceValueObject(BigDecimal.ZERO);
    private final BigDecimal value;

    private PriceValueObject(BigDecimal value) {
        this.value = value;
    }

    public PriceValueObject multiply(QuantityValueObject quantity) {
        BigDecimal multiplicand = BigDecimal.valueOf(quantity.get());

        return new PriceValueObject(value.multiply(multiplicand));
    }

    public PriceValueObject add(PriceValueObject price) {
        return new PriceValueObject(value.add(price.value));
    }
}

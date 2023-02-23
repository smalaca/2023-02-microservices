package com.smalaca.purchase.command.domain.product;

import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.quantity.QuantityValueObject;

import java.util.UUID;

public class ProductValueObject {
    private UUID id;
    private QuantityValueObject quantity;
    private PriceValueObject price;

    public PriceValueObject getTotalPrice() {
        return price.multiply(quantity);
    }
}

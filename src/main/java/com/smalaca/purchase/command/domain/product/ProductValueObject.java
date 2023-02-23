package com.smalaca.purchase.command.domain.product;

import com.smalaca.purchase.command.domain.price.PriceValueObject;

import java.util.UUID;

public class ProductValueObject {
    private UUID id;
    private QuantityValueObject quantity;
    private PriceValueObject price;
}

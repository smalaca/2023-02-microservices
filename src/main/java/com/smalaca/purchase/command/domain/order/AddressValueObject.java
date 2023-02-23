package com.smalaca.purchase.command.domain.order;

public class AddressValueObject {
    private final String city;
    private final String street;

    AddressValueObject(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

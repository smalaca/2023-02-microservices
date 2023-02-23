package com.smalaca.purchase.command.domain.order;

import org.springframework.stereotype.Component;

@Component
public class AddressValueObjectFactory {
    private final AddressService addressService;

    public AddressValueObjectFactory(AddressService addressService) {
        this.addressService = addressService;
    }

    public AddressValueObject create(String street, String city) {
        if (addressService.exists(street, city)) {
            return new AddressValueObject(street, city);
        }

        throw new NotExistingAddressException(street, city);
    }
}

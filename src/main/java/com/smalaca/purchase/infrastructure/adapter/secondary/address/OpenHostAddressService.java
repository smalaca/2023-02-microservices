package com.smalaca.purchase.infrastructure.adapter.secondary.address;

import com.smalaca.purchase.command.domain.order.AddressService;

public class OpenHostAddressService implements AddressService {
    @Override
    public boolean exists(String street, String city) {
        return false;
    }
}

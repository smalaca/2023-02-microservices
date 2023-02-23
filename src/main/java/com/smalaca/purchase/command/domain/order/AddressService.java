package com.smalaca.purchase.command.domain.order;

public interface AddressService {
    boolean exists(String street, String city);
}

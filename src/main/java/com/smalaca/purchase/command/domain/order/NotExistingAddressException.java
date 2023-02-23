package com.smalaca.purchase.command.domain.order;

class NotExistingAddressException extends RuntimeException {
    private final String street;
    private final String city;

    NotExistingAddressException(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

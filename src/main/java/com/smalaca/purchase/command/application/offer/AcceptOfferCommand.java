package com.smalaca.purchase.command.application.offer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AcceptOfferCommand {
    private UUID offerId;
    private String discountCode;
    private String deliveryMethod;
    private String city;
    private String street;

}

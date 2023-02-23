package com.smalaca.purchase.command.application.offer;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class AcceptOfferCommand {
    @NotNull
    private UUID offerId;
    private String discountCode;
    private String deliveryMethod;
    private String city;
    private String street;
}

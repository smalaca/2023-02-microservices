package com.smalaca.purchase.command.domain.offer;

import java.util.UUID;

public interface OfferRepository {
    OfferAggregateRoot findBy(UUID id);
}

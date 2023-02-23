package com.smalaca.purchase.command.domain.purchase;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseSagaRepository {
    void save(PurchaseSaga saga);

    Optional<PurchaseSaga> findBy(UUID purchaseId);
}

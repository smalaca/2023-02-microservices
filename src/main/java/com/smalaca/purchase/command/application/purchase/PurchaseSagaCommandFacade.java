package com.smalaca.purchase.command.application.purchase;

import com.smalaca.purchase.command.domain.purchase.OrderCreatedEvent;
import com.smalaca.purchase.command.domain.purchase.PurchaseSaga;
import com.smalaca.purchase.command.domain.purchase.PurchaseSagaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PurchaseSagaCommandFacade {
    private final PurchaseSagaRepository purchaseSagaRepository;

    public PurchaseSagaCommandFacade(PurchaseSagaRepository purchaseSagaRepository) {
        this.purchaseSagaRepository = purchaseSagaRepository;
    }

    public void listen(OrderCreatedEvent event) {
        //create or find saga & translate
        PurchaseSaga saga = findOrCreate(event.getTraceId());

        // one action
        saga.action(event);

        // save
        purchaseSagaRepository.save(saga);
    }

    private PurchaseSaga findOrCreate(UUID purchaseId) {
        Optional<PurchaseSaga> found = purchaseSagaRepository.findBy(purchaseId);

        if (found.isPresent()) {
            return found.get();
        }

        return new PurchaseSaga();
    }
}

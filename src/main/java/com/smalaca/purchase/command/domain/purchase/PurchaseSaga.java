package com.smalaca.purchase.command.domain.purchase;

public class PurchaseSaga {
    public void action(OrderCreatedEvent event) {
        if (isNotCompleted()) {
            // do something business specific
        }

//        tryComplete();
    }

    private boolean isNotCompleted() {
        return false;
    }

    private void tryComplete() {
        // if no event sourcing
    }
}

package com.smalaca.purchase.command.domain.order;

// Aggregate root
public class Order {
    private OrderState state;

    public void place(PaymentMethod paymentMethodVO) {
        state = OrderState.PLACED;
    }
}

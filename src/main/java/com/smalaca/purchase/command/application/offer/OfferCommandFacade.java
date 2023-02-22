package com.smalaca.purchase.command.application.offer;

import com.smalaca.purchase.command.domain.offer.Offer;
import com.smalaca.purchase.command.domain.offer.OfferRepository;
import com.smalaca.purchase.command.domain.order.Order;
import com.smalaca.purchase.command.domain.order.OrderRepository;

public class OfferCommandFacade {

    private final OrderRepository orderRepository;
    private final OfferRepository offerRepository;

    public OfferCommandFacade(OrderRepository orderRepository, OfferRepository offerRepository) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
    }

    public void accept(AcceptOfferCommand acceptOfferCommand){

        Offer offer = offerRepository.findBy(acceptOfferCommand.getOfferId());
        Order order = offer.accept();

        orderRepository.save(order);
    }
}

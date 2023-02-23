package com.smalaca.purchase.command.application.offer;

import com.smalaca.purchase.command.domain.order.AddressValueObjectFactory;
import com.smalaca.purchase.command.domain.offer.OfferAggregateRoot;
import com.smalaca.purchase.command.domain.offer.OfferRepository;
import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OfferCommandFacade {
    private final OrderRepository orderRepository;
    private final OfferRepository offerRepository;
    private final AddressValueObjectFactory addressValueObjectFactory;

    public OfferCommandFacade(OrderRepository orderRepository, OfferRepository offerRepository, AddressValueObjectFactory addressValueObjectFactory) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
        this.addressValueObjectFactory = addressValueObjectFactory;
    }

    @Transactional
    public void accept(AcceptOfferCommand acceptOfferCommand){
        OfferAggregateRoot offer = offerRepository.findBy(acceptOfferCommand.getOfferId());
        AddressValueObject address = addressValueObjectFactory.create(acceptOfferCommand.getStreet(), acceptOfferCommand.getCity());
        DeliveryMethodValueObject deliveryMethod = DeliveryMethodValueObject.from(acceptOfferCommand.getDeliveryMethod());

        OrderAggregateRoot order = offer.accept();

        orderRepository.save(order);
    }
}

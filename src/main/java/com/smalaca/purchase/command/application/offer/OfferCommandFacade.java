package com.smalaca.purchase.command.application.offer;

import com.smalaca.purchase.command.domain.offer.OfferAggregateRoot;
import com.smalaca.purchase.command.domain.offer.OfferRepository;
import com.smalaca.purchase.command.domain.offer.ParameterObject;
import com.smalaca.purchase.command.domain.offer.ParameterObjectFactory;
import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.AddressValueObjectFactory;
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
    private final ParameterObjectFactory parameterObjectFactory;

    public OfferCommandFacade(
            OrderRepository orderRepository, OfferRepository offerRepository, AddressValueObjectFactory addressValueObjectFactory, ParameterObjectFactory parameterObjectFactory) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
        this.addressValueObjectFactory = addressValueObjectFactory;
        this.parameterObjectFactory = parameterObjectFactory;
    }

    @Transactional
    public void accept(AcceptOfferCommand command){
        OfferAggregateRoot offer = offerRepository.findBy(command.getOfferId());
        AddressValueObject address = addressValueObjectFactory.create(command.getStreet(), command.getCity());
        DeliveryMethodValueObject deliveryMethod = DeliveryMethodValueObject.from(command.getDeliveryMethod());
        ParameterObject parameterObject = parameterObjectFactory.create(address, deliveryMethod, command.getDiscountCode());

        OrderAggregateRoot order = offer.accept(parameterObject);

        orderRepository.save(order);
    }
}

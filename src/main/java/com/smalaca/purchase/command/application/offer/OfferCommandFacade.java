package com.smalaca.purchase.command.application.offer;

import com.smalaca.purchase.command.domain.offer.OfferAggregateRoot;
import com.smalaca.purchase.command.domain.offer.OfferRepository;
import com.smalaca.purchase.command.domain.order.AddressValueObject;
import com.smalaca.purchase.command.domain.order.AddressValueObjectFactory;
import com.smalaca.purchase.command.domain.order.DeliveryMethodValueObject;
import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderFactory;
import com.smalaca.purchase.command.domain.order.OrderRepository;
import com.smalaca.purchase.command.domain.order.ParameterObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OfferCommandFacade {
    private final OrderRepository orderRepository;
    private final OfferRepository offerRepository;
    private final AddressValueObjectFactory addressValueObjectFactory;
    private final OrderFactory orderFactory;

    public OfferCommandFacade(
            OrderRepository orderRepository, OfferRepository offerRepository,
            AddressValueObjectFactory addressValueObjectFactory, OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
        this.addressValueObjectFactory = addressValueObjectFactory;
        this.orderFactory = orderFactory;
    }

    @Transactional
    public void accept(AcceptOfferCommand command){
        OfferAggregateRoot offer = offerRepository.findBy(command.getOfferId());
        ParameterObject parameterObject = asParameterObject(command);

        OrderAggregateRoot order = offer.accept(orderFactory, parameterObject);

        orderRepository.save(order);
    }

    private ParameterObject asParameterObject(AcceptOfferCommand command) {
        AddressValueObject address = addressValueObjectFactory.create(command.getStreet(), command.getCity());
        DeliveryMethodValueObject deliveryMethod = DeliveryMethodValueObject.from(command.getDeliveryMethod());

        return new ParameterObject(address, deliveryMethod, command.getDiscountCode());
    }
}

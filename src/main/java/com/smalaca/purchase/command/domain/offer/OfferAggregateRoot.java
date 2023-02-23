package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.OrderAggregateRoot;
import com.smalaca.purchase.command.domain.order.OrderFactory;
import com.smalaca.purchase.command.domain.order.AcceptOfferDomainCommand;
import com.smalaca.purchase.command.domain.product.ProductValueObject;

import java.util.List;

public class OfferAggregateRoot {
    private List<ProductValueObject> productVOS;

    public OrderAggregateRoot accept(OrderFactory orderFactory, AcceptOfferDomainCommand acceptOfferDomainCommand) {
        return orderFactory.create(productVOS, acceptOfferDomainCommand);
    }
}

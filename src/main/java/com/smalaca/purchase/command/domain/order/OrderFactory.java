package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.price.PriceValueObject;
import com.smalaca.purchase.command.domain.product.ProductValueObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactory {
    private final DiscountService discountService;

    public OrderFactory(DiscountService discountService) {
        this.discountService = discountService;
    }

    public OrderAggregateRoot create(List<ProductValueObject> products, AcceptOfferDomainCommand acceptOfferDomainCommand) {
        return OrderAggregateRoot.Builder.order()
                .with(products)
                .with(OrderNumberValueObject.generate())
                .with(OrderStateValueObject.CREATED)
                .with(acceptOfferDomainCommand.getAddress())
                .with(acceptOfferDomainCommand.getDeliveryMethod())
                .withDiscountCode(acceptOfferDomainCommand.getDiscountCode())
                .with(getFinalPriceFor(products, acceptOfferDomainCommand.getDiscountCode()))
                .build();
    }

    private PriceValueObject getFinalPriceFor(List<ProductValueObject> products, String discountCode) {
        PriceValueObject finalPrice = products.stream()
                .map(ProductValueObject::getTotalPrice)
                .reduce(PriceValueObject.ZERO, PriceValueObject::add);

        if (discountCode != null) {
            return discountService.withDiscount(finalPrice, discountCode);
        }

        return finalPrice;
    }
}

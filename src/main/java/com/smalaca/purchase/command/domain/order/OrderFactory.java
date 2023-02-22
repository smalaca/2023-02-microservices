package com.smalaca.purchase.command.domain.order;

import com.smalaca.purchase.command.domain.product.ProductVO;

import java.util.List;

public class OrderFactory {
    public static Order create(List<ProductVO> productVOS) {
        OrderNumber orderNumber = OrderNumber.generate();
        OrderState orderState = OrderState.CREATED;

        Order order = new Order(orderNumber, orderState, productVOS);
        return order;
    }
}

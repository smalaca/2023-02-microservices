package com.smalaca.purchase.command.domain.offer;

import com.smalaca.purchase.command.domain.order.Order;
import com.smalaca.purchase.command.domain.order.OrderFactory;
import com.smalaca.purchase.command.domain.product.ProductVO;

import java.util.List;

public class Offer {
    private List<ProductVO> productVOS;

    public Order accept() {
        Order order = OrderFactory.create(productVOS);
        return order;
    }
}

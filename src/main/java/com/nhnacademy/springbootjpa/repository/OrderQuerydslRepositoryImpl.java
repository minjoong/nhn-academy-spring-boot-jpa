package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import com.nhnacademy.springbootjpa.entity.Order;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.nhnacademy.springbootjpa.entity.QItem.item;
import static com.nhnacademy.springbootjpa.entity.QOrder.order;
import static com.nhnacademy.springbootjpa.entity.QOrderItem.orderItem;

public class OrderQuerydslRepositoryImpl extends QuerydslRepositorySupport implements OrderQuerydslRepository {

    public OrderQuerydslRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Item> findAllByHavingOrderItemQuantityGreaterThan(int quantity) {
        return from(order)
                .innerJoin(order.orderItems, orderItem)
                .innerJoin(orderItem.item, item)
                .where(orderItem.quantity.gt(quantity))
                .select(item)
                .distinct()
                .fetch();
    }
}

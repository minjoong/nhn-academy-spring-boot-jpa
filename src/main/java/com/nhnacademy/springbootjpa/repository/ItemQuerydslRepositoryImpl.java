package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

import static com.nhnacademy.springbootjpa.entity.QItem.item;
import static com.nhnacademy.springbootjpa.entity.QOrder.order;
import static com.nhnacademy.springbootjpa.entity.QOrderItem.orderItem;

// TODO #2: Custom Repository 구현
@Transactional(readOnly = true)
class ItemQuerydslRepositoryImpl extends QuerydslRepositorySupport implements ItemQuerydslRepository {

    public ItemQuerydslRepositoryImpl() {
        super(Item.class);
    }

    @Override
    public List<Item> findAllByOrderedAtAfter(ZonedDateTime orderedAt) {
        return from(item)
                .leftJoin(item.orderItems, orderItem)
                .innerJoin(orderItem.order, order)
                .where(order.orderedAt.after(orderedAt))
                .select(item)
                .fetch();
    }

}

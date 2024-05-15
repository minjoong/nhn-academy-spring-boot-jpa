package com.nhnacademy.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

// TODO #2: ItemView 프로젝션 인터페이스 - test case를 통과할 수 있도록 ItemView를 작성하세요.
public interface ItemView {

    List<OrderItemView> getOrderItems();

    interface OrderItemView {
        OrderView getOrder();
    }

    interface OrderView {
        @JsonFormat(pattern = "yyyy-MM-dd")
        ZonedDateTime getOrderedAt();
    }
}

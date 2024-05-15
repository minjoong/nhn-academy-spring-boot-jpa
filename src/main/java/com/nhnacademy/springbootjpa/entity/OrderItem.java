package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemPk pk;

    // TODO #1: 다대일 관계 설정
    @ManyToOne(optional = false)
    private Item item;

    private int quantity;
}

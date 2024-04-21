package com.nhnacademy.springbootjpa.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class OrderItemPk implements Serializable {
    private long orderId;
    private int lineNumber;
}

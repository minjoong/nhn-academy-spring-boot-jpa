package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;

import java.time.ZonedDateTime;
import java.util.List;

public interface ItemQuerydslRepository {
    List<Item> findAllByOrderedAtAfter(ZonedDateTime orderedAt);
}

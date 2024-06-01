package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    // TODO #1: `@EntityGraph` 어노테이션을 사용하여 `orderItems`와 `orderItems.order`를 fetch join으로 가져오도록 설정
    @EntityGraph(attributePaths = {"orderItems", "orderItems.order"})
    List<Item> findAllBy();
}

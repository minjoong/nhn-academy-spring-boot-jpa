package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    // TODO #1: JPQL `join fetch`
    @Query("select i" +
            " from Item i" +
            " left outer join fetch i.orderItems oi" +
            " inner join fetch oi.order o")
    List<Item> findAllWithAssociation();
}

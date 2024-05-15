package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // select *
    // from item
    // where name like '{name}'
    List<Item> findAllByNameLike(String name);

    // select id
    // from item
    // where name = '{name}'
    //   and price = {price}
    // limit 1
    boolean existsByNameAndPrice(String itemName, long price);

    // select count(*)
    // from item
    // where name like '%{name}%'
    int countByNameLike(String name);

    // delete
    // from item
    // where price between {price1} and {price2}
    void deleteAllByPriceBetween(long price1, long price2);

    // select *
    // from item
    // where price in (...)
    List<Item> findAllByPriceIn(List<Long> prices);
}

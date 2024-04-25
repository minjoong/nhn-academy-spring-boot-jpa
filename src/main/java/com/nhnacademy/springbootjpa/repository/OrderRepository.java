package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderedAtAfter(ZonedDateTime orderedAt);

    @Query("select o from Order o where o.orderedAt >= :orderedAt")
    List<Order> findAllByOrderedAtAfterByQuery(ZonedDateTime orderedAt);
}

package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Sql("item-test.sql")
    @Test
    void findAllByNameLikeTest() {
        // given
        String nameLike = "%ng%";

        // when
        List<Item> items = itemRepository.findAllByNameLike(nameLike);

        // then
        assertThat(items).hasSize(2);
    }

    @Sql("item-test.sql")
    @Test
    void existsByNameAndPriceTest() {
        // given
        String name = "mango";
        long price = 350L;

        // when
        boolean exists = itemRepository.existsByNameAndPrice(name, price);

        // then
        assertThat(exists).isTrue();
    }

    @Sql("item-test.sql")
    @Test
    void question() {
        // given
        List<Long> prices = List.of(100L, 200L);

        // when
        List<Item> items = itemRepository.findAllByPriceIn(prices);

        // then
        assertThat(items).hasSize(3);
    }

}

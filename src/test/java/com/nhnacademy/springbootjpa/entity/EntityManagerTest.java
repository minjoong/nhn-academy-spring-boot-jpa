package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EntityManagerTest {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO #1: 다음 테스트를 실행하면 수행될 쿼리는?
    @Test
    void test1() {
        User user1 = new User("newUser", "abcde");

        entityManager.persist(user1);

        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #2: 다음 테스트를 실행하면 수행될 쿼리는?
    @Test
    void test2() {
        User user1 = new User("newUser", "abcde");

        entityManager.persist(user1);
        entityManager.flush();          // <--

        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #3: 다음 테스트를 실행하면 수행될 쿼리는?
    @Test
    void test3() {
        User user1 = new User("newUser", "abcde");

        entityManager.persist(user1);

        User user2 = entityManager.find(User.class, "newUser");

        assertThat(user2).isEqualTo(user1);

        user2.setPassword("fghij");
        entityManager.flush();
    }

    // TODO #4: 다음 테스트를 실행하면 수행될 쿼리는?
    @Sql("entity-manager-test.sql")
    @Test
    void test4() {
        User user1 = entityManager.find(User.class, "admin");
        User user2 = entityManager.find(User.class, "admin");
        User user3 = entityManager.find(User.class, "admin");
        User user4 = entityManager.find(User.class, "admin");
        User user5 = entityManager.find(User.class, "admin");

        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isEqualTo(user3);
        assertThat(user1).isEqualTo(user4);
        assertThat(user1).isEqualTo(user5);
    }

}

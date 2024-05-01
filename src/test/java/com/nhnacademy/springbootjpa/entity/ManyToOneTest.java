package com.nhnacademy.springbootjpa.entity;

import com.nhnacademy.springbootjpa.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ManyToOneTest {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // TODO #2: 영속성 전이를 이용해서 저장하도록 수정
    @Test
    void test() {
        Member member = new Member("academy");

        postRepository.save(new Post("제목 제목1", "내용 내용1", member));
        postRepository.save(new Post("제목 제목2", "내용 내용2", member));

        entityManager.flush();
    }
}

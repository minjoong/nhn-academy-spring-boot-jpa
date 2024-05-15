package com.nhnacademy.springbootjpa.entity;

import com.nhnacademy.springbootjpa.repository.MemberRepository;
import com.nhnacademy.springbootjpa.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO #2: test case
@DataJpaTest
class OneToManyTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        Member member = memberRepository.save(new Member("academy"));

        Post post1 = postRepository.save(new Post("제목 제목1", "내용 내용1"));
        member.addPost(post1);

        Post post2 = postRepository.save(new Post("제목 제목2", "내용 내용2"));
        member.addPost(post2);

        entityManager.flush();
    }

}

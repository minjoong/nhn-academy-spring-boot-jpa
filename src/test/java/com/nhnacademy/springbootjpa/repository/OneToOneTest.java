package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Locker;
import com.nhnacademy.springbootjpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO #3: test case 수정
@DataJpaTest
class OneToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        Member member = new Member(1L, "academy");
        memberRepository.save(member);

        Locker locker = new Locker(1L, "No.1 Locker", member);
        lockerRepository.save(locker);

        entityManager.flush();
    }
}

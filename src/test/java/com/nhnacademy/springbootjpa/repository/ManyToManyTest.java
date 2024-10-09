package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import com.nhnacademy.springbootjpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ManyToManyTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        // member1 생성 후 저장
        Member member1 = new Member(1L, "member1");
        Member savedMember1 = memberRepository.save(member1);

        // member2 생성 후 저장
        Member member2 = new Member(2L, "member2");
        Member savedMember2 = memberRepository.save(member2);

        // team1 생성 (member1을 포함) 후 저장
        Team team1 = new Team(1L, "team1", List.of(savedMember1));
        Team savedTeam1 = teamRepository.save(team1);

        // team2 생성 (member1을 포함) 후 저장
        Team team2 = new Team(2L, "team2", List.of(savedMember1));
        Team savedTeam2 = teamRepository.save(team2);

        // entityManager.flush()를 호출하여 영속성 컨텍스트의 변경사항을 데이터베이스에 반영
        entityManager.flush();

        // team1에 member2 추가
        savedTeam1.addMember(savedMember2);

        // 다시 entityManager.flush()를 호출하여 영속성 컨텍스트의 변경사항을 데이터베이스에 반영
        // 변경 감지를 통해 명시적인 entityManager 또는 repository 메소드 호출 없이도 변경사항이 반영됨
        entityManager.flush();
    }

}
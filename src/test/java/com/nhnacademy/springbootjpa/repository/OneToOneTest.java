package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Board;
import com.nhnacademy.springbootjpa.entity.BoardDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class OneToOneTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardDetailRepository boardDetailRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // TODO #3: test case
    @Test
    void test() {
        Board board = new Board(1, "게시물 제목");
        Board savedBoard = boardRepository.save(board);

        BoardDetail boardDetail = new BoardDetail(savedBoard, "내용 내용 내용");
        boardDetailRepository.save(boardDetail);

        entityManager.flush();
    }
}

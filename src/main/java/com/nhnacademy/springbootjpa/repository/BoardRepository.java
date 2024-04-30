package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

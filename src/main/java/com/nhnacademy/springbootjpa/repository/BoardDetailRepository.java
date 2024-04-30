package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDetailRepository extends JpaRepository<BoardDetail, Long> {
}

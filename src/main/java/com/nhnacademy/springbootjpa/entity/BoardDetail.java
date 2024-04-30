package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO #2: `BoardDetail` Entity 생성
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BoardDetail {
    @Id
    private long boardId;

    @MapsId
    @OneToOne
    private Board board;

    private String content;

    public BoardDetail(Board board, String content) {
        this.board = board;
        this.content = content;
    }
}

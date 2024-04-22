package com.nhnacademy.springbootjpa.entity;

import java.time.ZonedDateTime;

// TODO #1: `question` 테이블과 매핑될 `Question` Entity 클래스를 작성하세요.
/*
 * create table question
 * (
 *     id         bigint auto_increment
 *         primary key,
 *     title      varchar(100) not null,
 *     content    text         not null,
 *     created_at datetime     not null
 * );
 */
public class Question {
    public long getId() {
        return 0;
    }

    public String getTitle() {
        return null;
    }

    public String getContent() {
        return null;
    }

    public ZonedDateTime getCreatedAt() {
        return null;
    }
}

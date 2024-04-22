package com.nhnacademy.springbootjpa.entity;

import java.time.ZonedDateTime;

// TODO #2: `answer` 테이블과 매핑될 `Answer` Entity 클래스를 작성하세요.
/*
 * create table answer
 * (
 *     id          bigint auto_increment
 *         primary key,
 *     question_id bigint   not null,
 *     content     text     not null,
 *     created_at  datetime not null
 * );
 */
public class Answer {
    public Answer(long questionId, String content, ZonedDateTime createdAt) {
    }

    public long getId() {
        return 0;
    }

    public long getQuestionId() {
        return 0;
    }

    public String getContent() {
        return null;
    }

    public ZonedDateTime getCreatedAt() {
        return null;
    }
}

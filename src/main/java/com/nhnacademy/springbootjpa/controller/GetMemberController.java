package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMemberController {

    // TODO #1: `GET /members?page=2&size=3` 와 같은 요청을 처리하도록 아래 코드를 완성하세요.
    @GetMapping("/members")
    public Page<MemberNameOnlyView> findAll() {
        return null;
    }
}

package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetMemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public Page<MemberNameOnlyView> findAll(Pageable pageable) {
        return memberRepository.findAllBy(pageable);
    }
}

package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.error.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    // TODO #1: DomainClassConverter를 이용해서 path variable로 Entity를 받음
    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") Optional<User> optionalUser) {
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}

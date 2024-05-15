package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import com.nhnacademy.springbootjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // TODO: `GET /users?page=1&size=5` 와 같은 요청을 처리할 수 있도록 구현
    @GetMapping("/users")
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

}

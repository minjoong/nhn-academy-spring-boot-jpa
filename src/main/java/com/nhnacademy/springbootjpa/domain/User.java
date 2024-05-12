package com.nhnacademy.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String id;
    private String password;
    private int age;
}

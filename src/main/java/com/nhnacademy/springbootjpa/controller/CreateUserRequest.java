package com.nhnacademy.springbootjpa.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

record CreateUserRequest(
        String id,
        @Length(min = 3, max = 20)
        @NotBlank
        String password,
        @Min(1)
        @Max(100)
        int age
) {
}

package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Enrollment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EnrollmentRepositoryTest {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Sql("enrollment-test.sql")
    @Test
    void test() {
        List<Enrollment> enrollments1 = enrollmentRepository.findAllByStudentName("nhn");
        assertThat(enrollments1).hasSize(3);

        List<Enrollment> enrollments2 = enrollmentRepository.findAllByCourseName("jpa");
        assertThat(enrollments2).hasSize(2);
    }

}

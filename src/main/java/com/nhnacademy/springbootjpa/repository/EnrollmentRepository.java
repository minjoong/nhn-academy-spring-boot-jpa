package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllByStudentName(String studentName);

    List<Enrollment> findAllByCourseName(String courseName);
}

package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.TeamMember;
import com.nhnacademy.springbootjpa.entity.TeamMemberPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, TeamMemberPk> {
}

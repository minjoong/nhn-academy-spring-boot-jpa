package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {

    @Id
    private Long id;

    @Setter
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "team_member",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    public Team(Long id, String name, List<Member> members) {
        this.id = id;
        this.name = name;
        // 생성자에서 전달된 리스트가 immutable일 수 있으니 명시적으로 ArrayList로 변환
        this.members = new ArrayList<>(members);
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        if (members == null) {
            members = new ArrayList<>();  // null일 경우 리스트 초기화
        }
        members.add(member);
    }

}

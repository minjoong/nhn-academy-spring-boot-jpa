package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Member {

    @Id
    private Long id;

    @Setter
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "members")
    private List<Team> teams;

    public Member(Long id, String name, List<Team> teams) {
        this.id = id;
        this.name = name;
        // 생성자에서 전달된 리스트가 immutable일 수 있으니 명시적으로 ArrayList로 변환
        this.teams = new ArrayList<>(teams);
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        if (teams == null) {
            teams = new ArrayList<>();  // null일 경우 리스트 초기화
        }
        teams.add(team);
    }

}

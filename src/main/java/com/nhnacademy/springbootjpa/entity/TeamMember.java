package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TeamMember {

    @EmbeddedId
    private TeamMemberPk id;

    @ManyToOne
    @MapsId("teamId")
    private Team team;

    @ManyToOne
    @MapsId("memberId")
    private Member member;

    public TeamMember(Team team, Member member) {
        this.team = team;
        this.member = member;
        this.id = new TeamMemberPk(team.getId(), member.getId());
    }

}

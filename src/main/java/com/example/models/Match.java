package com.example.models;

import javax.persistence.*;


@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024)
    private Long uid;
    private Long teamId;
    private String comment;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long userId) {
        this.uid = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String note) {
        this.comment = note;
    }

    public Long getMatchId() {
        return id;
    }

    public void setMatchId(Long matchId) {
        this.id = matchId;
    }


}

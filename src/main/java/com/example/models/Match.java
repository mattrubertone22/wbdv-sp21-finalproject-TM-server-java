package com.example.models;

import javax.persistence.*;

@Entity
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String[] participatingTeams;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String[] getParticipatingTeams() {
        return participatingTeams;
    }

    public void setParticipatingTeams(String[] participatingTeams) {
        this.participatingTeams = participatingTeams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

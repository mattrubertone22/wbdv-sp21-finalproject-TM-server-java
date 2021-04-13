package com.example.models;

import javax.persistence.*;

@Entity
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String[] participatingTeams;
}

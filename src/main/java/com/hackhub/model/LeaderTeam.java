package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "leader_team")
public class LeaderTeam extends MembroTeam {

    public LeaderTeam() {}

    public LeaderTeam(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }
}
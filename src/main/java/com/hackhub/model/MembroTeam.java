package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membri_team")
public class MembroTeam extends Utente {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public MembroTeam() {}

    public MembroTeam(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}
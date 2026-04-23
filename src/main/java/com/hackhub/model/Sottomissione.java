package com.hackhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sottomissioni")
public class Sottomissione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(name = "data_invio")
    private LocalDateTime dataInvio;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon hackathon;

    public Sottomissione() {}

    public Sottomissione(Long id, String link, Team team, Hackathon hackathon) {
        this.id = id;
        this.link = link;
        this.team = team;
        this.hackathon = hackathon;
        this.dataInvio = LocalDateTime.now();
    }

    public void aggiornaLink(String nuovoLink) {
        this.link = nuovoLink;
        System.out.println("Link aggiornato: " + nuovoLink);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public LocalDateTime getDataInvio() { return dataInvio; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
    public Hackathon getHackathon() { return hackathon; }
    public void setHackathon(Hackathon hackathon) { this.hackathon = hackathon; }
}
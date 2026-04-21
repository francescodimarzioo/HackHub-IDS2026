package com.hackhub.model;

import java.time.LocalDateTime;

public class Segnalazione {

    private Long id;
    private String descrizione;
    private LocalDateTime dataInvio;
    private Mentore segnalante;
    private Team teamSegnalato;
    private Hackathon hackathon;

    public Segnalazione(Long id, String descrizione, Mentore segnalante, Team teamSegnalato, Hackathon hackathon) {
        this.id = id;
        this.descrizione = descrizione;
        this.segnalante = segnalante;
        this.teamSegnalato = teamSegnalato;
        this.hackathon = hackathon;
        this.dataInvio = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public LocalDateTime getDataInvio() { return dataInvio; }
    public Mentore getSegnalante() { return segnalante; }
    public void setSegnalante(Mentore segnalante) { this.segnalante = segnalante; }
    public Team getTeamSegnalato() { return teamSegnalato; }
    public void setTeamSegnalato(Team teamSegnalato) { this.teamSegnalato = teamSegnalato; }
    public Hackathon getHackathon() { return hackathon; }
    public void setHackathon(Hackathon hackathon) { this.hackathon = hackathon; }
}
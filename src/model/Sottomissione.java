package model;

import java.time.LocalDateTime;

public class Sottomissione {

    private Long id;
    private String link;
    private LocalDateTime dataInvio;
    private Team team;
    private Hackathon hackathon;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getDataInvio() {
        return dataInvio;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }
}
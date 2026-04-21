package com.hackhub.model;

public class MembroTeam extends Utente {

    private Team team;

    public MembroTeam(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public void partecipaHackathon(Hackathon hackathon) {
        System.out.println("Membro " + getEmail() + " partecipa all'hackathon " + hackathon.getNome());
    }

    public void inviaRichiestaSupporto(Mentore mentore) {
        System.out.println("Membro " + getEmail() + " ha inviato una richiesta di supporto a " + mentore.getEmail());
    }

    public void inviaSegnalazione(Hackathon hackathon) {
        System.out.println("Membro " + getEmail() + " ha inviato una segnalazione per l'hackathon " + hackathon.getNome());
    }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}
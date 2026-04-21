package com.hackhub.model;

import java.util.ArrayList;
import java.util.List;

public class Organizzatore extends MembroStaff {

    private List<Hackathon> hackathonOrganizzati;

    public Organizzatore(Long id, String nome, String cognome, String email, String password, String bio, String linkProfilo) {
        super(id, nome, cognome, email, password, bio, linkProfilo);
        this.hackathonOrganizzati = new ArrayList<>();
    }

    public Hackathon creaHackathon(String nome, String regolamento, String luogo, Double premioInDenaro, int dimensioneMaxTeam) {
        Hackathon hackathon = new Hackathon(null, nome, regolamento, luogo, premioInDenaro, dimensioneMaxTeam, this);
        hackathonOrganizzati.add(hackathon);
        System.out.println("Hackathon " + nome + " creato da " + getEmail());
        return hackathon;
    }

    public void avviaFaseIscrizione(Hackathon hackathon) {
        hackathon.setStato(StatoHackathon.IN_ISCRIZIONE);
        System.out.println("Fase iscrizione avviata per " + hackathon.getNome());
    }

    public void concludiFaseIscrizione(Hackathon hackathon) {
        hackathon.setStato(StatoHackathon.IN_CORSO);
        System.out.println("Fase iscrizione conclusa per " + hackathon.getNome());
    }

    public void avviaFaseSvolgimento(Hackathon hackathon) {
        hackathon.setStato(StatoHackathon.IN_VALUTAZIONE);
        System.out.println("Fase svolgimento avviata per " + hackathon.getNome());
    }

    public void concludiFaseSvolgimento(Hackathon hackathon) {
        hackathon.setStato(StatoHackathon.CONCLUSO);
        System.out.println("Fase svolgimento conclusa per " + hackathon.getNome());
    }

    public List<Hackathon> getHackathonOrganizzati() { return hackathonOrganizzati; }
}

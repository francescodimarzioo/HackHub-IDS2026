package com.hackhub.model;

public class Mentore extends MembroStaff {

    private String specializzazione;

    public Mentore(Long id, String nome, String cognome, String email,
                   String password, String bio, String linkProfilo,
                   String specializzazione) {
        super(id, nome, cognome, email, password, bio, linkProfilo);
        this.specializzazione = specializzazione;
    }

    public void accettaRichiestaSupporto(RichiestaSupporto richiesta) {
        richiesta.accetta(this);
        System.out.println("Mentore " + getEmail() + " ha accettato la richiesta.");
    }

    public void concludiSupporto(RichiestaSupporto richiesta) {
        richiesta.concludi();
        System.out.println("Mentore " + getEmail() + " ha concluso il supporto.");
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
}
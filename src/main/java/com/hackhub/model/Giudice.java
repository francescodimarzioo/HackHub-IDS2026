package com.hackhub.model;

public class Giudice extends MembroStaff {

    private String criterioValutazione;

    public Giudice(Long id, String nome, String cognome, String email,
                   String password, String bio, String linkProfilo,
                   String criterioValutazione) {
        super(id, nome, cognome, email, password, bio, linkProfilo);
        this.criterioValutazione = criterioValutazione;
    }

    public Valutazione valutaSottomissione(Sottomissione sottomissione,
                                           String giudizio, int punteggio) {
        Valutazione valutazione = new Valutazione(null, giudizio, punteggio, sottomissione, this);
        System.out.println("Giudice " + getEmail() + " ha valutato la sottomissione.");
        return valutazione;
    }

    public String getCriterioValutazione() {
        return criterioValutazione;
    }

    public void setCriterioValutazione(String criterioValutazione) {
        this.criterioValutazione = criterioValutazione;
    }
}

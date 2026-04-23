package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "giudici")
public class Giudice extends MembroStaff {

    @Column(name = "criterio_valutazione")
    private String criterioValutazione;

    public Giudice() {}

    public Giudice(Long id, String nome, String cognome, String email, String password,
                   String bio, String linkProfilo, String criterioValutazione) {
        super(id, nome, cognome, email, password);
        setBio(bio);
        setLinkProfilo(linkProfilo);
        this.criterioValutazione = criterioValutazione;
    }

    public Valutazione valutaSottomissione(Sottomissione sottomissione,
                                           String giudizio, int punteggio) {
        Valutazione valutazione = new Valutazione(null, giudizio, (double) punteggio, sottomissione, this);
        System.out.println("Giudice " + getEmail() + " ha valutato la sottomissione.");
        return valutazione;
    }

    public String getCriterioValutazione() { return criterioValutazione; }
    public void setCriterioValutazione(String criterioValutazione) {
        this.criterioValutazione = criterioValutazione;
    }
}
package com.hackhub.model;

public class Valutazione {

    private Long id;
    private String giudizio;
    private int punteggio;
    private Sottomissione sottomissione;
    private Giudice giudice;

    public Valutazione(Long id, String giudizio, int punteggio,
                       Sottomissione sottomissione, Giudice giudice) {
        this.id = id;
        this.giudizio = giudizio;
        this.punteggio = punteggio;
        this.sottomissione = sottomissione;
        this.giudice = giudice;
    }

    public String getGiudizio() {
        return giudizio;
    }

    public void setGiudizio(String giudizio) {
        this.giudizio = giudizio;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sottomissione getSottomissione() {
        return sottomissione;
    }

    public void setSottomissione(Sottomissione sottomissione) {
        this.sottomissione = sottomissione;
    }

    public Giudice getGiudice() {
        return giudice;
    }

    public void setGiudice(Giudice giudice) {
        this.giudice = giudice;
    }
}
package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "valutazioni")
public class Valutazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String giudizio;

    @Column(nullable = false)
    private Double punteggio;

    @ManyToOne
    @JoinColumn(name = "sottomissione_id")
    private Sottomissione sottomissione;

    @ManyToOne
    @JoinColumn(name = "giudice_id")
    private Giudice giudice;

    public Valutazione() {}

    public Valutazione(Long id, String giudizio, Double punteggio, Sottomissione sottomissione, Giudice giudice) {
        this.id = id;
        this.giudizio = giudizio;
        this.punteggio = punteggio;
        this.sottomissione = sottomissione;
        this.giudice = giudice;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGiudizio() { return giudizio; }
    public void setGiudizio(String giudizio) { this.giudizio = giudizio; }
    public Double getPunteggio() { return punteggio; }
    public void setPunteggio(Double punteggio) { this.punteggio = punteggio; }
    public Sottomissione getSottomissione() { return sottomissione; }
    public void setSottomissione(Sottomissione sottomissione) { this.sottomissione = sottomissione; }
    public Giudice getGiudice() { return giudice; }
    public void setGiudice(Giudice giudice) { this.giudice = giudice; }
}
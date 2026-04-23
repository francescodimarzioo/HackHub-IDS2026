package com.hackhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "segnalazioni")
public class Segnalazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descrizione;

    @Column(name = "data_invio")
    private LocalDateTime dataInvio;

    @Column(nullable = false)
    private String stato;

    @ManyToOne
    @JoinColumn(name = "segnalante_id")
    private MembroTeam segnalante;

    @ManyToOne
    @JoinColumn(name = "membro_staff_id")
    private MembroStaff membroStaff;

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon hackathon;

    public Segnalazione() {}

    public Segnalazione(Long id, String descrizione, MembroTeam segnalante, Hackathon hackathon) {
        this.id = id;
        this.descrizione = descrizione;
        this.segnalante = segnalante;
        this.hackathon = hackathon;
        this.dataInvio = LocalDateTime.now();
        this.stato = "IN_ATTESA";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public LocalDateTime getDataInvio() { return dataInvio; }
    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
    public MembroTeam getSegnalante() { return segnalante; }
    public void setSegnalante(MembroTeam segnalante) { this.segnalante = segnalante; }
    public MembroStaff getMembroStaff() { return membroStaff; }
    public void setMembroStaff(MembroStaff membroStaff) { this.membroStaff = membroStaff; }
    public Hackathon getHackathon() { return hackathon; }
    public void setHackathon(Hackathon hackathon) { this.hackathon = hackathon; }
}
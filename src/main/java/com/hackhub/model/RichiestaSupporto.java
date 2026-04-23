package com.hackhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "richieste_supporto")
public class RichiestaSupporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descrizione;

    @Column(name = "data_richiesta")
    private LocalDateTime dataRichiesta;

    @Column(nullable = false)
    private String stato;

    @Column(name = "link_call")
    private String linkCall;

    @ManyToOne
    @JoinColumn(name = "richiedente_id")
    private MembroTeam richiedente;

    @ManyToOne
    @JoinColumn(name = "mentore_id")
    private Mentore mentore;

    public RichiestaSupporto() {}

    public RichiestaSupporto(Long id, String descrizione, MembroTeam richiedente) {
        this.id = id;
        this.descrizione = descrizione;
        this.richiedente = richiedente;
        this.dataRichiesta = LocalDateTime.now();
        this.stato = "IN_ATTESA";
    }

    public void accetta(Mentore mentore) {
        this.mentore = mentore;
        this.stato = "ACCETTATA";
        System.out.println("Richiesta accettata da " + mentore.getEmail());
    }

    public void concludi() {
        this.stato = "CONCLUSA";
        System.out.println("Richiesta conclusa.");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public LocalDateTime getDataRichiesta() { return dataRichiesta; }
    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
    public String getLinkCall() { return linkCall; }
    public void setLinkCall(String linkCall) { this.linkCall = linkCall; }
    public MembroTeam getRichiedente() { return richiedente; }
    public void setRichiedente(MembroTeam richiedente) { this.richiedente = richiedente; }
    public Mentore getMentore() { return mentore; }
    public void setMentore(Mentore mentore) { this.mentore = mentore; }
}
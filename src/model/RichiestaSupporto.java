package model;

import java.time.LocalDateTime;

public class RichiestaSupporto {

    private Long id;
    private String descrizione;
    private LocalDateTime dataRichiesta;
    private String stato;
    private MembroTeam richiedente;
    private Mentore mentore;

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
    public MembroTeam getRichiedente() { return richiedente; }
    public void setRichiedente(MembroTeam richiedente) { this.richiedente = richiedente; }
    public Mentore getMentore() { return mentore; }
    public void setMentore(Mentore mentore) { this.mentore = mentore; }
}
package com.hackhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hackathon")
public class Hackathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String regolamento;

    @Column(name = "scadenza_iscrizioni")
    private LocalDateTime scadenzaIscrizioni;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Column
    private String luogo;

    @Column(name = "premio_in_denaro")
    private Double premioInDenaro;

    @Column(name = "dimensione_max_team")
    private int dimensioneMaxTeam;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoHackathon stato;

    @ManyToOne
    @JoinColumn(name = "organizzatore_id")
    private Organizzatore organizzatore;

    @OneToMany(mappedBy = "hackathon", cascade = CascadeType.ALL)
    private List<Team> team = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_vincitore_id")
    private Team teamVincitore;

    @ManyToMany
    @JoinTable(
            name = "hackathon_mentori",
            joinColumns = @JoinColumn(name = "hackathon_id"),
            inverseJoinColumns = @JoinColumn(name = "mentore_id")
    )
    private List<Mentore> mentori = new ArrayList<>();

    public Hackathon() {}

    public Hackathon(Long id, String nome, String regolamento, String luogo,
                     Double premioInDenaro, int dimensioneMaxTeam,
                     Organizzatore organizzatore) {
        this.id = id;
        this.nome = nome;
        this.regolamento = regolamento;
        this.luogo = luogo;
        this.premioInDenaro = premioInDenaro;
        this.dimensioneMaxTeam = dimensioneMaxTeam;
        this.organizzatore = organizzatore;
        this.stato = StatoHackathon.IN_ATTESA;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRegolamento() { return regolamento; }
    public void setRegolamento(String regolamento) { this.regolamento = regolamento; }
    public LocalDateTime getScadenzaIscrizioni() { return scadenzaIscrizioni; }
    public void setScadenzaIscrizioni(LocalDateTime scadenzaIscrizioni) { this.scadenzaIscrizioni = scadenzaIscrizioni; }
    public LocalDateTime getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDateTime dataInizio) { this.dataInizio = dataInizio; }
    public LocalDateTime getDataFine() { return dataFine; }
    public void setDataFine(LocalDateTime dataFine) { this.dataFine = dataFine; }
    public String getLuogo() { return luogo; }
    public void setLuogo(String luogo) { this.luogo = luogo; }
    public Double getPremioInDenaro() { return premioInDenaro; }
    public void setPremioInDenaro(Double premioInDenaro) { this.premioInDenaro = premioInDenaro; }
    public int getDimensioneMaxTeam() { return dimensioneMaxTeam; }
    public void setDimensioneMaxTeam(int dimensioneMaxTeam) { this.dimensioneMaxTeam = dimensioneMaxTeam; }
    public StatoHackathon getStato() { return stato; }
    public void setStato(StatoHackathon stato) { this.stato = stato; }
    public Organizzatore getOrganizzatore() { return organizzatore; }
    public void setOrganizzatore(Organizzatore organizzatore) { this.organizzatore = organizzatore; }
    public List<Team> getTeam() { return team; }
    public void setTeam(List<Team> team) { this.team = team; }
    public Team getTeamVincitore() { return teamVincitore; }
    public void setTeamVincitore(Team teamVincitore) { this.teamVincitore = teamVincitore; }
    public List<Mentore> getMentori() { return mentori; }
    public void setMentori(List<Mentore> mentori) { this.mentori = mentori; }
}
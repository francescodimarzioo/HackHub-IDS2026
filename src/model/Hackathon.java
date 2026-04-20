package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {

    private Long id;
    private String nome;
    private String regolamento;
    private LocalDateTime scadenzaIscrizioni;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String luogo;
    private Double premioInDenaro;
    private int dimensioneMaxTeam;
    private StatoHackathon stato;
    private Organizzatore organizzatore;
    private List<Team> team;
    private Team teamVincitore;

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
        this.team = new ArrayList<>();
    }

    public StatoHackathon getStato() {
        return stato;
    }

    public void setStato(StatoHackathon stato) {
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegolamento() {
        return regolamento;
    }

    public void setRegolamento(String regolamento) {
        this.regolamento = regolamento;
    }

    public LocalDateTime getScadenzaIscrizioni() {
        return scadenzaIscrizioni;
    }

    public void setScadenzaIscrizioni(LocalDateTime scadenzaIscrizioni) {
        this.scadenzaIscrizioni = scadenzaIscrizioni;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Double getPremioInDenaro() {
        return premioInDenaro;
    }

    public void setPremioInDenaro(Double premioInDenaro) {
        this.premioInDenaro = premioInDenaro;
    }

    public int getDimensioneMaxTeam() {
        return dimensioneMaxTeam;
    }

    public void setDimensioneMaxTeam(int dimensioneMaxTeam) {
        this.dimensioneMaxTeam = dimensioneMaxTeam;
    }

    public Organizzatore getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(Organizzatore organizzatore) {
        this.organizzatore = organizzatore;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }
    public Team getTeamVincitore() {
        return teamVincitore;
    }

    public void setTeamVincitore(Team teamVincitore) {
        this.teamVincitore = teamVincitore;
    }

    private List<Mentore> mentori = new ArrayList<>();

    public List<Mentore> getMentori() {
        return mentori;
    }

    public void setMentori(List<Mentore> mentori) {
        this.mentori = mentori;
    }

}

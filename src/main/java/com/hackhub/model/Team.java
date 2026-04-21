package com.hackhub.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;
    private String nome;
    private Hackathon hackathon;
    private List<MembroTeam> membri;
    private LeaderTeam leader;

    public Team(Long id, String nome, Hackathon hackathon, LeaderTeam leader) {
        this.id = id;
        this.nome = nome;
        this.hackathon = hackathon;
        this.leader = leader;
        this.membri = new ArrayList<>();
    }

    public void aggiungiMembro(MembroTeam membro) {
        membri.add(membro);
        membro.setTeam(this);
        System.out.println("Membro " + membro.getEmail() + " aggiunto al team " + nome);
    }

    public void rimuoviMembro(MembroTeam membro) {
        membri.remove(membro);
        System.out.println("Membro " + membro.getEmail() + " rimosso dal team " + nome);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Hackathon getHackathon() { return hackathon; }
    public void setHackathon(Hackathon hackathon) { this.hackathon = hackathon; }
    public List<MembroTeam> getMembri() { return membri; }
    public LeaderTeam getLeader() { return leader; }
    public void setLeader(LeaderTeam leader) { this.leader = leader; }
}

package com.hackhub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon hackathon;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<MembroTeam> membri = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "leader_id")
    private LeaderTeam leader;

    public Team() {}

    public Team(Long id, String nome, Hackathon hackathon, LeaderTeam leader) {
        this.id = id;
        this.nome = nome;
        this.hackathon = hackathon;
        this.leader = leader;
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

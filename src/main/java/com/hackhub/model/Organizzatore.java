package com.hackhub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizzatori")
public class Organizzatore extends MembroStaff {

    @OneToMany(mappedBy = "organizzatore", cascade = CascadeType.ALL)
    private List<Hackathon> hackathonOrganizzati = new ArrayList<>();

    public Organizzatore() {}

    public Organizzatore(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public List<Hackathon> getHackathonOrganizzati() { return hackathonOrganizzati; }
    public void setHackathonOrganizzati(List<Hackathon> hackathonOrganizzati) {
        this.hackathonOrganizzati = hackathonOrganizzati;
    }
}
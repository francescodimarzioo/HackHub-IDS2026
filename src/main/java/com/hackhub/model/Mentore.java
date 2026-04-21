package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mentori")
public class Mentore extends MembroStaff {

    @Column
    private String specializzazione;

    public Mentore() {}

    public Mentore(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public String getSpecializzazione() { return specializzazione; }
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
}
package com.hackhub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membri_staff")
public class MembroStaff extends Utente {

    @Column
    private String bio;

    @Column(name = "link_profilo")
    private String linkProfilo;

    public MembroStaff() {}

    public MembroStaff(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getLinkProfilo() { return linkProfilo; }
    public void setLinkProfilo(String linkProfilo) { this.linkProfilo = linkProfilo; }
}
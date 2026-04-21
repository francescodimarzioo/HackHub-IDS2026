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
    @JoinColumn(name = "memb
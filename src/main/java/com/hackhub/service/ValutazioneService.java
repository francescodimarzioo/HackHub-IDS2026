package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;

import com.hackhub.model.Giudice;
import com.hackhub.model.Sottomissione;
import com.hackhub.model.StatoHackathon;
import com.hackhub.model.Valutazione;
import com.hackhub.repository.ISottomissioneRepository;
import com.hackhub.repository.IValutazioneRepository;

public class ValutazioneService {

    private IValutazioneRepository valutazioneRepository;
    private ISottomissioneRepository sottomissioneRepository;

    public ValutazioneService(IValutazioneRepository valutazioneRepository,
                              ISottomissioneRepository sottomissioneRepository) {
        this.valutazioneRepository = valutazioneRepository;
        this.sottomissioneRepository = sottomissioneRepository;
    }

    public Valutazione valutaSottomissione(Long idSottomissione, String giudizio,
                                           int punteggio, Giudice giudice) {
        Sottomissione sottomissione = sottomissioneRepository.findById(idSottomissione);
        if (sottomissione == null) {
            throw new IllegalArgumentException("Sottomissione non trovata");
        }
        if (sottomissione.getHackathon().getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalStateException("Hackathon non in stato IN_VALUTAZIONE");
        }

        Valutazione esistente = valutazioneRepository.findBySottomissione(sottomissione);
        if (esistente != null) {
            throw new IllegalStateException("Sottomissione già valutata");
        }

        Valutazione valutazione = new Valutazione(null, giudizio, (double) punteggio,
                sottomissione, giudice);
        System.out.println("Sottomissione valutata dal giudice " + giudice.getEmail());
        return valutazioneRepository.save(valutazione);
    }
}
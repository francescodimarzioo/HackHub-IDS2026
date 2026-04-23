package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValutazioneService {

    @Autowired
    private IValutazioneRepository valutazioneRepository;

    @Autowired
    private ISottomissioneRepository sottomissioneRepository;

    public Valutazione valutaSottomissione(Long idSottomissione, String giudizio,
                                           int punteggio, Giudice giudice) {
        Sottomissione sottomissione = sottomissioneRepository.findById(idSottomissione).orElse(null);
        if (sottomissione == null) {
            throw new IllegalArgumentException("Sottomissione non trovata");
        }
        if (sottomissione.getHackathon().getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalStateException("Hackathon non in stato IN_VALUTAZIONE");
        }

        Valutazione esistente = valutazioneRepository.findBySottomissione(sottomissione).orElse(null);
        if (esistente != null) {
            throw new IllegalStateException("Sottomissione già valutata");
        }

        Valutazione valutazione = new Valutazione(null, giudizio, (double) punteggio,
                sottomissione, giudice);
        System.out.println("Sottomissione valutata dal giudice " + giudice.getEmail());
        return valutazioneRepository.save(valutazione);
    }
}
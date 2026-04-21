package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.Sottomissione;
import com.hackhub.model.Valutazione;
import java.util.List;

public interface IValutazioneRepository {

    Valutazione findById(Long id);

    Valutazione findBySottomissione(Sottomissione sottomissione);

    List<Valutazione> findByHackathon(Hackathon hackathon);

    Valutazione save(Valutazione valutazione);
}
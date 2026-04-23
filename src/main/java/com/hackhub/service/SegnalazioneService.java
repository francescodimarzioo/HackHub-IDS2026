package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegnalazioneService {

    @Autowired
    private ISegnalazioneRepository segnalazioneRepository;

    @Autowired
    private IHackathonRepository hackathonRepository;

    public Segnalazione inviaSegnalazione(Long idHackathon, String descrizione, Long idMembroTeam) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon).orElse(null);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Hackathon non in stato IN_CORSO");
        }

        MembroTeam segnalante = new MembroTeam();
        segnalante.setId(idMembroTeam);

        Segnalazione segnalazione = new Segnalazione(null, descrizione, segnalante, hackathon);
        return segnalazioneRepository.save(segnalazione);
    }

    public Segnalazione gestisciSegnalazione(Long idSegnalazione, String azione, Long idMembroStaff) {
        Segnalazione segnalazione = segnalazioneRepository.findById(idSegnalazione).orElse(null);
        if (segnalazione == null) {
            throw new IllegalArgumentException("Segnalazione non trovata");
        }
        if (!segnalazione.getStato().equals("IN_ATTESA")) {
            throw new IllegalStateException("Segnalazione già gestita");
        }

        MembroStaff membroStaff = new MembroStaff();
        membroStaff.setId(idMembroStaff);
        segnalazione.setMembroStaff(membroStaff);

        if (azione.equals("ACCETTA")) {
            segnalazione.setStato("ACCETTATA");
        } else if (azione.equals("RIFIUTA")) {
            segnalazione.setStato("RIFIUTATA");
        } else {
            throw new IllegalArgumentException("Azione non valida");
        }

        return segnalazioneRepository.save(segnalazione);
    }
}
package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import com.hackhub.pattern.LinkCallStrategy;
import com.hackhub.pattern.ZoomStrategy;
import com.hackhub.pattern.GoogleMeetStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportoService {

    @Autowired
    private IRichiestaSupportoRepository richiestaSupportoRepository;

    public RichiestaSupporto richiedeSupporto(Long idMembroTeam, String descrizione) {
        MembroTeam richiedente = new MembroTeam();
        richiedente.setId(idMembroTeam);
        RichiestaSupporto richiesta = new RichiestaSupporto(null, descrizione, richiedente);
        return richiestaSupportoRepository.save(richiesta);
    }

    public RichiestaSupporto gestisciRichiesta(Long idRichiesta, String azione, Long idMentore) {
        RichiestaSupporto richiesta = richiestaSupportoRepository.findById(idRichiesta).orElse(null);
        if (richiesta == null) {
            throw new IllegalArgumentException("Richiesta non trovata");
        }
        if (!richiesta.getStato().equals("IN_ATTESA")) {
            throw new IllegalStateException("Richiesta già gestita");
        }
        Mentore mentore = new Mentore();
        mentore.setId(idMentore);
        if (azione.equals("ACCETTA")) {
            richiesta.accetta(mentore);
        } else if (azione.equals("RIFIUTA")) {
            richiesta.setStato("RIFIUTATA");
        } else {
            throw new IllegalArgumentException("Azione non valida");
        }
        return richiestaSupportoRepository.save(richiesta);
    }

    public RichiestaSupporto proporCall(Long idRichiesta, String tipoCall, Long idMentore) {
        RichiestaSupporto richiesta = richiestaSupportoRepository.findById(idRichiesta).orElse(null);
        if (richiesta == null) {
            throw new IllegalArgumentException("Richiesta non trovata");
        }
        if (!richiesta.getStato().equals("ACCETTATA")) {
            throw new IllegalStateException("Richiesta non in stato corretto");
        }
        if (!richiesta.getMentore().getId().equals(idMentore)) {
            throw new IllegalArgumentException("Mentore non autorizzato");
        }

        LinkCallStrategy strategy;
        if (tipoCall.equals("ZOOM")) {
            strategy = new ZoomStrategy();
        } else if (tipoCall.equals("GOOGLE_MEET")) {
            strategy = new GoogleMeetStrategy();
        } else {
            throw new IllegalArgumentException("Tipo call non valido");
        }

        String link = strategy.generaLink(idRichiesta);
        richiesta.setLinkCall(link);
        return richiestaSupportoRepository.save(richiesta);
    }
}
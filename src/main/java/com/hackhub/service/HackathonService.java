package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.Organizzatore;
import com.hackhub.model.StatoHackathon;
import com.hackhub.repository.IHackathonRepository;
import com.hackhub.model.Mentore;
import com.hackhub.model.Team;
import com.hackhub.pattern.PagamentoFacade;

public class HackathonService {

    private IHackathonRepository hackathonRepository;

    public HackathonService(IHackathonRepository hackathonRepository) {
        this.hackathonRepository = hackathonRepository;
    }

    public Hackathon creaHackathon(String nome, String regolamento, String luogo,
                                   Double premioInDenaro, int dimensioneMaxTeam,
                                   Organizzatore organizzatore) {
        Hackathon hackathon = new Hackathon(null, nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam, organizzatore);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon avviaFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_ATTESA) {
            throw new IllegalStateException("Stato non valido per avviare la fase iscrizione");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_ISCRIZIONE);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon concludiFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Stato non valido per concludere la fase iscrizione");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_CORSO);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon avviaFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Stato non valido per avviare la fase svolgimento");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_VALUTAZIONE);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon concludiFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalStateException("Stato non valido per concludere la fase svolgimento");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.CONCLUSO);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon proclamaVincitore(Long idHackathon, Long idTeamVincitore, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalStateException("Stato non valido per proclamare il vincitore");
        }

        Team vincitore = null;
        for (Team t : hackathon.getTeam()) {
            if (t.getId().equals(idTeamVincitore)) {
                vincitore = t;
                break;
            }
        }
        if (vincitore == null) {
            throw new IllegalArgumentException("Team vincitore non trovato");
        }

        hackathon.setTeamVincitore(vincitore);
        hackathon.setStato(StatoHackathon.CONCLUSO);
        System.out.println("Vincitore proclamato: " + vincitore.getNome());
        return hackathonRepository.save(hackathon);
    }

    public void erogaPremio(Long idHackathon) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.CONCLUSO) {
            throw new IllegalStateException("Stato non valido per erogare il premio");
        }
        if (hackathon.getTeamVincitore() == null) {
            throw new IllegalStateException("Nessun team vincitore proclamato");
        }

        PagamentoFacade pagamentoFacade = new PagamentoFacade();
        pagamentoFacade.erogaPremio(hackathon.getTeamVincitore(), hackathon.getPremioInDenaro());
    }

    public Hackathon modificaHackathon(Long idHackathon, String nome, String regolamento,
                                       String luogo, Double premioInDenaro,
                                       int dimensioneMaxTeam, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_ATTESA) {
            throw new IllegalStateException("Stato non valido per modificare l'hackathon");
        }

        hackathon.setNome(nome);
        hackathon.setRegolamento(regolamento);
        hackathon.setLuogo(luogo);
        hackathon.setPremioInDenaro(premioInDenaro);
        hackathon.setDimensioneMaxTeam(dimensioneMaxTeam);
        System.out.println("Hackathon " + hackathon.getNome() + " modificato.");
        return hackathonRepository.save(hackathon);
    }

    public Hackathon aggiungiMentore(Long idHackathon, Mentore mentore, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        if (hackathon.getStato() == StatoHackathon.CONCLUSO) {
            throw new IllegalStateException("Non è possibile aggiungere mentori a un hackathon concluso");
        }
        if (hackathon.getMentori().contains(mentore)) {
            throw new IllegalStateException("Mentore già assegnato all'hackathon");
        }

        hackathon.getMentori().add(mentore);
        System.out.println("Mentore " + mentore.getEmail() + " aggiunto all'hackathon " + hackathon.getNome());
        return hackathonRepository.save(hackathon);
    }

    public void verificaScadenzaIscrizioni() {
        System.out.println("Verifica scadenza iscrizioni in corso...");
    }
}
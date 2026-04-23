package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SottomissioneService {

    @Autowired
    private ISottomissioneRepository sottomissioneRepository;

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private IHackathonRepository hackathonRepository;

    public Sottomissione inviaSottomissione(Long idTeam, Long idHackathon,
                                            String link, Long idLeader) {
        Team team = teamRepository.findById(idTeam).orElse(null);
        if (team == null) {
            throw new IllegalArgumentException("Team non trovato");
        }
        if (!team.getLeader().getId().equals(idLeader)) {
            throw new IllegalArgumentException("Leader non autorizzato");
        }
        if (team.getHackathon().getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Hackathon non in stato IN_CORSO");
        }

        List<Sottomissione> esistenti = sottomissioneRepository.findByTeam(team);
        if (!esistenti.isEmpty()) {
            throw new IllegalStateException("Il team ha già inviato una sottomissione");
        }

        Sottomissione sottomissione = new Sottomissione(null, link, team, team.getHackathon());
        System.out.println("Sottomissione inviata dal team " + team.getNome());
        return sottomissioneRepository.save(sottomissione);
    }

    public Sottomissione aggiornaSottomissione(Long idSottomissione,
                                               String nuovoLink, Long idLeader) {
        Sottomissione sottomissione = sottomissioneRepository.findById(idSottomissione).orElse(null);
        if (sottomissione == null) {
            throw new IllegalArgumentException("Sottomissione non trovata");
        }
        if (!sottomissione.getTeam().getLeader().getId().equals(idLeader)) {
            throw new IllegalArgumentException("Leader non autorizzato");
        }
        if (sottomissione.getTeam().getHackathon().getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Hackathon non più in stato IN_CORSO");
        }

        sottomissione.aggiornaLink(nuovoLink);
        return sottomissioneRepository.save(sottomissione);
    }

    public List<Sottomissione> visualizzaSottomissioni(Long idHackathon, Long idGiudice) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon).orElse(null);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        List<Sottomissione> sottomissioni = sottomissioneRepository.findByHackathon(hackathon);
        if (sottomissioni.isEmpty()) {
            System.out.println("Nessuna sottomissione trovata per questo hackathon.");
        }
        return sottomissioni;
    }
}
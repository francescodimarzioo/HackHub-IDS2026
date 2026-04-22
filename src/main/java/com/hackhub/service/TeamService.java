package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private IHackathonRepository hackathonRepository;

    public Team creaTeam(Long idHackathon, String nomeTeam, LeaderTeam leader) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon).orElse(null);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }

        Team team = new Team(null, nomeTeam, hackathon, leader);
        return teamRepository.save(team);
    }

    public Team iscriviTeam(Long idTeam, Long idHackathon, Long idLeader) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon).orElse(null);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }

        Team team = teamRepository.findById(idTeam).orElse(null);
        if (team == null) {
            throw new IllegalArgumentException("Team non trovato");
        }

        if (!team.getLeader().getId().equals(idLeader)) {
            throw new IllegalArgumentException("Leader non autorizzato");
        }

        if (hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Hackathon non in fase di iscrizione");
        }

        hackathon.getTeam().add(team);
        hackathonRepository.save(hackathon);
        return team;
    }

    public Team abbandonaTeam(Long idTeam, Long idMembroTeam) {
        Team team = teamRepository.findById(idTeam).orElse(null);
        if (team == null) {
            throw new IllegalArgumentException("Team non trovato");
        }

        Hackathon hackathon = team.getHackathon();
        if (hackathon != null && hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Non puoi abbandonare il team in questa fase");
        }

        MembroTeam membro = team.getMembri().stream()
                .filter(m -> m.getId().equals(idMembroTeam))
                .findFirst().orElse(null);
        if (membro == null) {
            throw new IllegalArgumentException("Membro non trovato nel team");
        }

        team.rimuoviMembro(membro);
        return teamRepository.save(team);
    }
}
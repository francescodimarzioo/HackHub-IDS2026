package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.LeaderTeam;
import com.hackhub.model.StatoHackathon;
import com.hackhub.model.Team;
import com.hackhub.repository.IHackathonRepository;
import com.hackhub.repository.ITeamRepository;

public class TeamService {

    private ITeamRepository teamRepository;
    private IHackathonRepository hackathonRepository;

    public TeamService(ITeamRepository teamRepository,
                       IHackathonRepository hackathonRepository) {
        this.teamRepository = teamRepository;
        this.hackathonRepository = hackathonRepository;
    }

    public Team creaTeam(Long idHackathon, String nomeTeam, LeaderTeam leader) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }

        Team esistente = teamRepository.findByHackathonAndLeader(hackathon, leader);
        if (esistente != null) {
            throw new IllegalStateException("Leader ha già un team in questo hackathon");
        }

        Team team = new Team(null, nomeTeam, hackathon, leader);
        return teamRepository.save(team);
    }

    public Team iscriviTeam(Long idTeam, Long idHackathon, Long idLeader) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }

        Team team = teamRepository.findById(idTeam);
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
}
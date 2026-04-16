package controller;

import model.LeaderTeam;
import model.Team;
import service.TeamService;
import validator.TeamValidator;

public class TeamController {

    private TeamService teamService;
    private TeamValidator teamValidator;

    public TeamController(TeamService teamService, TeamValidator teamValidator) {
        this.teamService = teamService;
        this.teamValidator = teamValidator;
    }

    public Team creaTeam(Long idHackathon, String nomeTeam, LeaderTeam leader) {
        teamValidator.validateInputCreaTeam(idHackathon, nomeTeam, leader.getId());
        return teamService.creaTeam(idHackathon, nomeTeam, leader);
    }

    public Team iscriviTeam(Long idTeam, Long idHackathon, Long idLeader) {
        teamValidator.validateInputIscriviTeam(idTeam, idHackathon, idLeader);
        return teamService.iscriviTeam(idTeam, idHackathon, idLeader);
    }
}
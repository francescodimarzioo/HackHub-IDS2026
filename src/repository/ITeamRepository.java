package repository;

import model.Hackathon;
import model.LeaderTeam;
import model.Team;

public interface ITeamRepository {

    Team findById(Long id);

    Team findByHackathonAndLeader(Hackathon hackathon, LeaderTeam leader);

    Team save(Team team);
}
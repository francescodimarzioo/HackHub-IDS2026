package repository;

import model.Hackathon;
import model.LeaderTeam;
import model.Team;
import java.util.ArrayList;
import java.util.List;

public class TeamRepositoryImpl implements ITeamRepository {

    private List<Team> teams = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Team findById(Long id) {
        for (Team t : teams) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Team findByHackathonAndLeader(Hackathon hackathon, LeaderTeam leader) {
        for (Team t : teams) {
            if (t.getHackathon().getId().equals(hackathon.getId())
                    && t.getLeader().getId().equals(leader.getId())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Team save(Team team) {
        if (team.getId() == null) {
            team.setId(nextId++);
            teams.add(team);
        } else {
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getId().equals(team.getId())) {
                    teams.set(i, team);
                    return team;
                }
            }
        }
        return team;
    }
}
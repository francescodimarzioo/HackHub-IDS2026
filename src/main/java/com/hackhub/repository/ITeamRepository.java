package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.LeaderTeam;
import com.hackhub.model.Team;

public interface ITeamRepository {

    Team findById(Long id);

    Team findByHackathonAndLeader(Hackathon hackathon, LeaderTeam leader);

    Team save(Team team);
}
package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.Sottomissione;
import com.hackhub.model.Team;
import java.util.List;

public interface ISottomissioneRepository {

    Sottomissione findById(Long id);

    Sottomissione findByTeam(Team team);

    List<Sottomissione> findByHackathon(Hackathon hackathon);

    Sottomissione save(Sottomissione sottomissione);
}
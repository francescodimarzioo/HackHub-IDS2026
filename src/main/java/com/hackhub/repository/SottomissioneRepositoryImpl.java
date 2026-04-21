package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.Sottomissione;
import com.hackhub.model.Team;
import java.util.ArrayList;
import java.util.List;

public class SottomissioneRepositoryImpl implements ISottomissioneRepository {

    private List<Sottomissione> sottomissioni = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Sottomissione findById(Long id) {
        for (Sottomissione s : sottomissioni) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Sottomissione findByTeam(Team team) {
        for (Sottomissione s : sottomissioni) {
            if (s.getTeam().getId().equals(team.getId())) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Sottomissione> findByHackathon(Hackathon hackathon) {
        List<Sottomissione> result = new ArrayList<>();
        for (Sottomissione s : sottomissioni) {
            if (s.getHackathon().getId().equals(hackathon.getId())) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public Sottomissione save(Sottomissione sottomissione) {
        if (sottomissione.getId() == null) {
            sottomissione.setId(nextId++);
            sottomissioni.add(sottomissione);
        } else {
            for (int i = 0; i < sottomissioni.size(); i++) {
                if (sottomissioni.get(i).getId().equals(sottomissione.getId())) {
                    sottomissioni.set(i, sottomissione);
                    return sottomissione;
                }
            }
        }
        return sottomissione;
    }
}
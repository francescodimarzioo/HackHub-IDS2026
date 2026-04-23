package com.hackhub.repository;

import com.hackhub.model.Sottomissione;
import com.hackhub.model.Team;
import com.hackhub.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISottomissioneRepository extends JpaRepository<Sottomissione, Long> {
    List<Sottomissione> findByTeam(Team team);
    List<Sottomissione> findByHackathon(Hackathon hackathon);
}
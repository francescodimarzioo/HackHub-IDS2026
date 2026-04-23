package com.hackhub.repository;

import com.hackhub.model.Valutazione;
import com.hackhub.model.Sottomissione;
import com.hackhub.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IValutazioneRepository extends JpaRepository<Valutazione, Long> {
    Optional<Valutazione> findBySottomissione(Sottomissione sottomissione);
    List<Valutazione> findBySottomissioneHackathon(Hackathon hackathon);
}
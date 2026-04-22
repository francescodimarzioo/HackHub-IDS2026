package com.hackhub.repository;

import com.hackhub.model.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISegnalazioneRepository extends JpaRepository<Segnalazione, Long> {
}
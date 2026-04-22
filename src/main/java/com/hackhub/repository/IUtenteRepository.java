package com.hackhub.repository;

import com.hackhub.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmail(String email);
}
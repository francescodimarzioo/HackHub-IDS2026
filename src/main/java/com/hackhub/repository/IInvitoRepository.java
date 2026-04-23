package com.hackhub.repository;

import com.hackhub.model.Invito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvitoRepository extends JpaRepository<Invito, Long> {
}
package com.hackhub.repository;

import com.hackhub.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHackathonRepository extends JpaRepository<Hackathon, Long> {
}
package com.hackhub.repository;

import com.hackhub.model.RichiestaSupporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRichiestaSupportoRepository extends JpaRepository<RichiestaSupporto, Long> {
}
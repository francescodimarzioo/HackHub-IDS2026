package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Hackathon;

public interface IHackathonRepository {

    Hackathon findById(Long id);

    Hackathon save(Hackathon hackathon);
}
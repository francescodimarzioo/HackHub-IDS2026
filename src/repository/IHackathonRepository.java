package repository;

import model.Hackathon;

public interface IHackathonRepository {

    Hackathon findById(Long id);

    Hackathon save(Hackathon hackathon);
}
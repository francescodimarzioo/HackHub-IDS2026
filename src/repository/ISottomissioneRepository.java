package repository;

import model.Hackathon;
import model.Sottomissione;
import model.Team;
import java.util.List;

public interface ISottomissioneRepository {

    Sottomissione findById(Long id);

    Sottomissione findByTeam(Team team);

    List<Sottomissione> findByHackathon(Hackathon hackathon);

    Sottomissione save(Sottomissione sottomissione);
}
package repository;

import model.Hackathon;
import model.Sottomissione;
import model.Valutazione;
import java.util.List;

public interface IValutazioneRepository {

    Valutazione findById(Long id);

    Valutazione findBySottomissione(Sottomissione sottomissione);

    List<Valutazione> findByHackathon(Hackathon hackathon);

    Valutazione save(Valutazione valutazione);
}
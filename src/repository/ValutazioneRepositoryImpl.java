package repository;

import model.Hackathon;
import model.Sottomissione;
import model.Valutazione;
import java.util.ArrayList;
import java.util.List;

public class ValutazioneRepositoryImpl implements IValutazioneRepository {

    private List<Valutazione> valutazioni = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Valutazione findById(Long id) {
        for (Valutazione v : valutazioni) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public Valutazione findBySottomissione(Sottomissione sottomissione) {
        for (Valutazione v : valutazioni) {
            if (v.getSottomissione().getId().equals(sottomissione.getId())) {
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Valutazione> findByHackathon(Hackathon hackathon) {
        List<Valutazione> result = new ArrayList<>();
        for (Valutazione v : valutazioni) {
            if (v.getSottomissione().getHackathon().getId().equals(hackathon.getId())) {
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public Valutazione save(Valutazione valutazione) {
        if (valutazione.getId() == null) {
            valutazione.setId(nextId++);
            valutazioni.add(valutazione);
        } else {
            for (int i = 0; i < valutazioni.size(); i++) {
                if (valutazioni.get(i).getId().equals(valutazione.getId())) {
                    valutazioni.set(i, valutazione);
                    return valutazione;
                }
            }
        }
        return valutazione;
    }
}
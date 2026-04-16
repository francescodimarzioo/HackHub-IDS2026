package repository;

import model.Hackathon;
import java.util.ArrayList;
import java.util.List;

public class HackathonRepositoryImpl implements IHackathonRepository {

    private List<Hackathon> hackathons = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Hackathon findById(Long id) {
        for (Hackathon h : hackathons) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }

    @Override
    public Hackathon save(Hackathon hackathon) {
        if (hackathon.getId() == null) {
            hackathon.setId(nextId++);
            hackathons.add(hackathon);
        } else {
            for (int i = 0; i < hackathons.size(); i++) {
                if (hackathons.get(i).getId().equals(hackathon.getId())) {
                    hackathons.set(i, hackathon);
                    return hackathon;
                }
            }
        }
        return hackathon;
    }
}
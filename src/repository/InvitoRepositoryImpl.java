package repository;

import model.Invito;
import java.util.ArrayList;
import java.util.List;

public class InvitoRepositoryImpl implements IInvitoRepository {

    private List<Invito> inviti = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Invito findById(Long id) {
        for (Invito i : inviti) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Invito save(Invito invito) {
        if (invito.getId() == null) {
            invito.setId(nextId++);
            inviti.add(invito);
        } else {
            for (int i = 0; i < inviti.size(); i++) {
                if (inviti.get(i).getId().equals(invito.getId())) {
                    inviti.set(i, invito);
                    return invito;
                }
            }
        }
        return invito;
    }
}
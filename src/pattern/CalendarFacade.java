package pattern;

import model.Mentore;
import model.Team;

import java.time.LocalDateTime;

public class CalendarFacade {

    public void prenotaSlot(Mentore mentore, Team team, LocalDateTime data) {
        System.out.println("Slot prenotato per il mentore " + mentore.getEmail()
                + " con il team " + team.getNome()
                + " in data " + data);
    }

    public void cancellaSlot(Long idSlot) {
        System.out.println("Slot " + idSlot + " cancellato.");
    }
}
package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/segnalazione")
public class SegnalazioneController {

    @Autowired
    private SegnalazioneService segnalazioneService;

    @PostMapping("/invia")
    public ResponseEntity<Segnalazione> inviaSegnalazione(@RequestParam Long idHackathon,
                                                          @RequestParam String descrizione,
                                                          @RequestParam Long idMembroTeam) {
        return ResponseEntity.ok(segnalazioneService.inviaSegnalazione(idHackathon, descrizione, idMembroTeam));
    }

    @PutMapping("/{idSegnalazione}/gestisci")
    public ResponseEntity<Segnalazione> gestisciSegnalazione(@PathVariable Long idSegnalazione,
                                                             @RequestParam String azione,
                                                             @RequestParam Long idMembroStaff) {
        return ResponseEntity.ok(segnalazioneService.gestisciSegnalazione(idSegnalazione, azione, idMembroStaff));
    }
}
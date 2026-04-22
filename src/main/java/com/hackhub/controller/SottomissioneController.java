package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sottomissione")
public class SottomissioneController {

    @Autowired
    private SottomissioneService sottomissioneService;

    @Autowired
    private SottomissioneValidator sottomissioneValidator;

    @PostMapping("/invia")
    public ResponseEntity<Sottomissione> inviaSottomissione(@RequestParam Long idTeam,
                                                            @RequestParam Long idHackathon,
                                                            @RequestParam String link,
                                                            @RequestParam Long idLeader) {
        sottomissioneValidator.validateInputInvia(idTeam, idHackathon, link, idLeader);
        return ResponseEntity.ok(sottomissioneService.inviaSottomissione(idTeam, idHackathon, link, idLeader));
    }

    @PutMapping("/{idSottomissione}/aggiorna")
    public ResponseEntity<Sottomissione> aggiornaSottomissione(@PathVariable Long idSottomissione,
                                                               @RequestParam String nuovoLink,
                                                               @RequestParam Long idLeader) {
        sottomissioneValidator.validateInputAggiorna(idSottomissione, nuovoLink, idLeader);
        return ResponseEntity.ok(sottomissioneService.aggiornaSottomissione(idSottomissione, nuovoLink, idLeader));
    }

    @GetMapping("/{idHackathon}/lista")
    public ResponseEntity<List<Sottomissione>> visualizzaSottomissioni(@PathVariable Long idHackathon,
                                                                       @RequestParam Long idGiudice) {
        return ResponseEntity.ok(sottomissioneService.visualizzaSottomissioni(idHackathon, idGiudice));
    }
}
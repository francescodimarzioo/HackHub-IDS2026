package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invito")
public class InvitoController {

    @Autowired
    private InvitoService invitoService;

    @Autowired
    private InvitoValidator invitoValidator;

    @PostMapping("/invita")
    public ResponseEntity<Invito> invitaUtente(@RequestParam Long idTeam,
                                               @RequestParam Long idDestinatario,
                                               @RequestParam Long idLeader) {
        invitoValidator.validateInputUtente(idTeam, idDestinatario, idLeader);
        return ResponseEntity.ok(invitoService.invitaUtente(idTeam, idDestinatario, idLeader));
    }

    @PutMapping("/{idInvito}/rispondi")
    public ResponseEntity<Invito> rispondiInvito(@PathVariable Long idInvito,
                                                 @RequestParam String risposta,
                                                 @RequestParam Long idUtente) {
        invitoValidator.validateInputRisposta(idInvito, risposta, idUtente);
        return ResponseEntity.ok(invitoService.rispondiInvito(idInvito, risposta, idUtente));
    }
}
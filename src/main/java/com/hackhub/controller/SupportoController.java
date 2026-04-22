package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supporto")
public class SupportoController {

    @Autowired
    private SupportoService supportoService;

    @PostMapping("/richiedi")
    public ResponseEntity<RichiestaSupporto> richiedeSupporto(@RequestParam Long idMembroTeam,
                                                              @RequestParam String descrizione) {
        return ResponseEntity.ok(supportoService.richiedeSupporto(idMembroTeam, descrizione));
    }

    @PutMapping("/{idRichiesta}/gestisci")
    public ResponseEntity<RichiestaSupporto> gestisciRichiesta(@PathVariable Long idRichiesta,
                                                               @RequestParam String azione,
                                                               @RequestParam Long idMentore) {
        return ResponseEntity.ok(supportoService.gestisciRichiesta(idRichiesta, azione, idMentore));
    }

    @PutMapping("/{idRichiesta}/proponi-call")
    public ResponseEntity<RichiestaSupporto> proporCall(@PathVariable Long idRichiesta,
                                                        @RequestParam String tipoCall,
                                                        @RequestParam Long idMentore) {
        return ResponseEntity.ok(supportoService.proporCall(idRichiesta, tipoCall, idMentore));
    }
}
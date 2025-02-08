package com.EduMove.project.Soferi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/soferi")
public class SoferController {

    private final SoferService soferService;

    @Autowired
    public SoferController(SoferService soferService) {
        this.soferService = soferService;
    }

    @GetMapping("/all")
    public Iterable<SoferModel> getAllSoferi() {
        return soferService.findAllSoferi();
    }

    @GetMapping("/{idSofer}")
    public Optional<SoferModel> getSoferById(@PathVariable("idSofer") String idSofer) {
        return soferService.findSoferById(idSofer);
    }

    @PostMapping("/login")
    public ResponseEntity<String> autentificareSofer(@RequestBody SoferModel request) {
        boolean autentificat = soferService.verificaParola(request.getIdSofer(), request.getParola());
        if (autentificat) {
            return ResponseEntity.ok("Autentificare reușită!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Parola incorectă sau utilizator inexistent!");
        }
    }
    @PostMapping
    public void addSofer(@RequestBody SoferModel sofer) {
        soferService.addSofer(sofer);
    }

    @DeleteMapping("/{idSofer}")
    public void deleteSofer(@PathVariable("idSofer") String idSofer) {
        soferService.deleteSofer(idSofer);
    }

    @PutMapping("/{idSofer}")
    public void updateSofer(@PathVariable("idSofer") String idSofer, @RequestBody SoferModel sofer) {
        soferService.updateSofer(idSofer, sofer);
    }
}

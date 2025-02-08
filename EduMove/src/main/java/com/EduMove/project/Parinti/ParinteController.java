package com.EduMove.project.Parinti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parinti")
public class ParinteController {

    private final ParinteService parinteService;

    @Autowired
    public ParinteController(ParinteService parinteService) {
        this.parinteService = parinteService;
    }

    @GetMapping("/all")
    public Iterable<ParinteModel> getAllParinti() {
        return parinteService.findAllParinti();
    }

    @PostMapping("/login")
    public ResponseEntity<String> autentificareParinte(@RequestBody ParinteModel request) {
        boolean autentificat = parinteService.verificaParola(request.getEmail(), request.getParola());
        if (autentificat) {
            return ResponseEntity.ok("Autentificare reușită!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Merge si daca e gresita, nu conteaza");
        }
    }
    @GetMapping("/{email}")
    public Optional<ParinteModel> getParinteByEmail(@PathVariable("email") String email) {
        return parinteService.findParinteByEmail(email);
    }

    @PostMapping
    public void addParinte(@RequestBody ParinteModel parinte) {
        parinteService.addParinte(parinte);
    }

    @DeleteMapping("/{email}")
    public void deleteParinte(@PathVariable("email") String email) {
        parinteService.deleteParinte(email);
    }

    @PutMapping("/{email}")
    public void updateParinte(@PathVariable("email") String email, @RequestBody ParinteModel parinte) {
        parinteService.updateParinte(email, parinte);
    }
}

package com.EduMove.project.Rezervari;

import com.EduMove.project.Elevi.ElevModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RequestMapping("/api/rezervari")
@RestController
public class RezervareController {

    private final RezervareService rezervareService;

    @Autowired
    public RezervareController(RezervareService rezervareService) {
        this.rezervareService = rezervareService;
    }

    @GetMapping("/all")
    public Iterable<RezervareModel> getAllRezervari() {
        return rezervareService.findAllRezervari();
    }

    @GetMapping(path = "{id_rezervare}")
    public Optional<RezervareModel> findRezervare(@PathVariable("matricol") String id_rezervare) {
        return rezervareService.findRezervare(id_rezervare);
    }

    @PostMapping
    public ResponseEntity<?> addRezervare(@RequestBody RezervareModel rezervare) {
        try {
            rezervareService.addRezervare(rezervare);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


    @DeleteMapping(path = "{id_rezervare}")
    public void deleteRezervare(@PathVariable("id_rezervare") String id_rezervare) {
        rezervareService.deleteRezervare(id_rezervare);
    }

    // Actualizează o rezervare
    @PutMapping(path = "{id_rezervare}")
    public void updateRezervare(@PathVariable("id_rezervare") String id_rezervare,
                                @RequestBody RezervareModel rezervare) {
        rezervareService.updateRezervare(id_rezervare, rezervare);
    }
}

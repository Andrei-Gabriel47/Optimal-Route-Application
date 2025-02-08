package com.EduMove.project.Elevi;

import com.EduMove.project.ElevAutentificare.ElevAutentificareRequest;
import com.EduMove.project.ElevAutentificare.EmailService;
import com.EduMove.project.Elevi.ElevModel;
import com.EduMove.project.Elevi.ElevService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/elevi")
@RestController
public class ElevController {

    private final ElevService elevService;
    @Autowired
    private EmailService emailService;
    @Autowired
    public ElevController(ElevService elevService) {
        this.elevService = elevService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> autentificareElev(@RequestBody ElevAutentificareRequest request) {
        boolean autentificat = elevService.verificaParola(request.getMatricol(), request.getParola());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> response = new HashMap<>();

        try {
            if (autentificat) {
                response.put("message", "Autentificare reușită!");
                String jsonResponse = mapper.writeValueAsString(response);
                return ResponseEntity.ok(jsonResponse);
            } else {
                response.put("message", "Parola incorectă sau utilizator inexistent!");
                String jsonResponse = mapper.writeValueAsString(response);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jsonResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eroare la generarea răspunsului JSON.");
        }
    }

    @PostMapping("/trimite-parola")
    public ResponseEntity<String> trimiteParola(@RequestBody ElevModel elev) {
        try {
            elevService.trimiteParola(elev.getMatricol());
            return ResponseEntity.ok("Parola a fost trimisă pe e-mail.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @GetMapping("/all")
    public Iterable<ElevModel> getAllElevi() {
        return elevService.findAllElevi();
    }

    @GetMapping(path = "{matricol}")
    public Optional<ElevModel> findElevByMatricol(@PathVariable("matricol") String matricol) {
        return elevService.findElevByMatricol(matricol);
    }

    @PostMapping
    public ResponseEntity<?> addElev(@RequestBody ElevModel elev) {
        try {
            elevService.addElev(elev);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @DeleteMapping(path = "{matricol}")
    public void deleteElev(@PathVariable("matricol") String matricol) {
        elevService.deleteElev(matricol);
    }

    @PutMapping(path = "{matricol}")
    public void updateElev(@PathVariable("matricol") String matricol, @RequestBody ElevModel elev) {
        elevService.updateElev(matricol, elev);
    }
}

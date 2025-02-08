package com.EduMove.project.Statii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/statii")
@RestController
public class StatieController {

    private final StatieService statieService;

    @Autowired
    public StatieController(StatieService statieService) {
        this.statieService = statieService;
    }

    @GetMapping("/all")
    public Iterable<StatieModel> getAllStatii() {
        return statieService.findAllStatii();
    }


    @GetMapping(path = "{idStatie}")
    public Optional<StatieModel> findStatieById(@PathVariable("idStatie") String idStatie) {
        return statieService.findStatieById(idStatie);
    }


    @PostMapping
    public void addStatie(@RequestBody StatieModel statie) {
        statieService.addStatie(statie);
    }


    @DeleteMapping(path = "{idStatie}")
    public void deleteStatie(@PathVariable("idStatie") String idStatie) {
        statieService.deleteStatie(idStatie);
    }


    @PutMapping(path = "{idStatie}")
    public void updateStatie(@PathVariable("idStatie") String idStatie, @RequestBody StatieModel statie) {
        statieService.updateStatie(idStatie, statie);
    }
}

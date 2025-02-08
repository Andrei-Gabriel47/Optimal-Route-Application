package com.EduMove.project.Statii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatieService {

    private final StatieRepository statieRepository;

    @Autowired
    public StatieService(StatieRepository statieRepository) {
        this.statieRepository = statieRepository;
    }


    public Iterable<StatieModel> findAllStatii() {
        return statieRepository.findAll();
    }

    public Optional<StatieModel> findStatieById(String idStatie) {
        return statieRepository.findById(idStatie);
    }


    public void addStatie(StatieModel statie) {
        statieRepository.save(statie);
    }

    public void deleteStatie(String idStatie) {
        statieRepository.deleteById(idStatie);
    }

    public void updateStatie(String idStatie, StatieModel statie) {
        Optional<StatieModel> existingStatie = statieRepository.findById(idStatie);
        if (existingStatie.isPresent()) {
            StatieModel updatedStatie = existingStatie.get();
            updatedStatie.setNumeStatie(statie.getNumeStatie());
            updatedStatie.setLatitudine(statie.getLatitudine());
            updatedStatie.setLongitudine(statie.getLongitudine());
            statieRepository.save(updatedStatie);
        }
    }
}

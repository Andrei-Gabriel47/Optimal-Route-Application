package com.EduMove.project.Rezervari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RezervareService {

    private final RezervareRepository rezervareRepository;

    @Autowired
    public RezervareService(RezervareRepository rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }


    public Iterable<RezervareModel> findAllRezervari() {
        return rezervareRepository.findAll();
    }


    public Optional<RezervareModel> findRezervare(String id_rezervare) {
        return rezervareRepository.findById(id_rezervare); // Sau adăugăm o metodă personalizată pentru a căuta după 3 câmpuri
    }


    public void addRezervare(RezervareModel rezervare) {
        rezervareRepository.insertRezervare(rezervare.getId_rezervare(), rezervare.getMatricol() , rezervare.getId_statie(),rezervare.getData_rezervare());
    }


    public void deleteRezervare(String id_rezervare) {
        rezervareRepository.deleteById(id_rezervare); // Sau adăugăm o metodă personalizată pentru a șterge după 3 câmpuri
    }

    public void updateRezervare(String id_rezervare, RezervareModel rezervare) {
        Optional<RezervareModel> existingRezervare = rezervareRepository.findById(id_rezervare); // O metodă personalizată pentru 3 câmpuri
        if (existingRezervare.isPresent()) {
            RezervareModel updatedRezervare = existingRezervare.get();
            updatedRezervare.setId_statie(rezervare.getId_statie());
            updatedRezervare.setData_rezervare(rezervare.getData_rezervare());
            rezervareRepository.save(updatedRezervare);
        }
    }
}

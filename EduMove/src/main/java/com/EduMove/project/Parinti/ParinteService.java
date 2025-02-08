package com.EduMove.project.Parinti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParinteService {

    private final ParinteRepository parinteRepository;

    @Autowired
    public ParinteService(ParinteRepository parinteRepository) {
        this.parinteRepository = parinteRepository;
    }

    public Iterable<ParinteModel> findAllParinti() {
        return parinteRepository.findAll();
    }

    public Optional<ParinteModel> findParinteByEmail(String email) {
        return parinteRepository.findById(email);
    }

    public void addParinte(ParinteModel parinte) {
        parinteRepository.save(parinte);
    }

    public void deleteParinte(String email) {
        parinteRepository.deleteById(email);
    }

    public void updateParinte(String email, ParinteModel parinte) {
        Optional<ParinteModel> oldParinte = parinteRepository.findById(email);
        if (oldParinte.isPresent()) {
            ParinteModel updatedParinte = oldParinte.get();
            updatedParinte.setMatricolCopil(parinte.getMatricolCopil());
            updatedParinte.setNumeParinte(parinte.getNumeParinte());
            updatedParinte.setPrenumeParinte(parinte.getPrenumeParinte());
            updatedParinte.setCnp(parinte.getCnp());
            updatedParinte.setParola(parinte.getParola());
            parinteRepository.save(updatedParinte);
        }
    }

    public boolean verificaParola(String email, String parolaIntroducere) {
        Optional<ParinteModel> optionalParinte = parinteRepository.findById(email);
        if (optionalParinte.isPresent()) {
            ParinteModel parinte = optionalParinte.get();
            return parolaIntroducere.matches(parinte.getParola());
        }
        return false;
    }
}

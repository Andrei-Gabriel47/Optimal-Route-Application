package com.EduMove.project.Soferi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoferService {

    private final SoferRepository soferRepository;

    @Autowired
    public SoferService(SoferRepository soferRepository) {
        this.soferRepository = soferRepository;
    }

    public Iterable<SoferModel> findAllSoferi() {
        return soferRepository.findAll();
    }

    public Optional<SoferModel> findSoferById(String idSofer) {
        return soferRepository.findById(idSofer);
    }

    public void addSofer(SoferModel sofer) {
        soferRepository.save(sofer);
    }

    public void deleteSofer(String idSofer) {
        soferRepository.deleteById(idSofer);
    }
    public boolean verificaParola(String idSofer, String parolaIntroducere) {
        Optional<SoferModel> optionalSofer = soferRepository.findById(idSofer);
        if (optionalSofer.isPresent()) {
            SoferModel sofer = optionalSofer.get();
            return parolaIntroducere.matches(sofer.getParola());
        }
        return false;
    }

    public void updateSofer(String idSofer, SoferModel sofer) {
        Optional<SoferModel> oldSofer = soferRepository.findById(idSofer);
        if (oldSofer.isPresent()) {
            SoferModel updatedSofer = oldSofer.get();
            updatedSofer.setNume(sofer.getNume());
            updatedSofer.setPrenume(sofer.getPrenume());
            updatedSofer.setCnp(sofer.getCnp());
            updatedSofer.setParola(sofer.getParola());
            soferRepository.save(updatedSofer);
        }
    }
}

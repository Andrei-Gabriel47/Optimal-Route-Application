package com.EduMove.project.Elevi;

import com.EduMove.project.ElevAutentificare.EmailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class ElevService {

    private final ElevRepository elevRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    // Metodă pentru a trimite parola pe email
    public void trimiteParola(String matricol) {
        logger.info("Caut elevul cu matricolul: {}", matricol);
        Optional<ElevModel> elevOpt = elevRepository.findById(matricol);
        if (elevOpt.isPresent()) {
            ElevModel elev = elevOpt.get();
            String parolaNecriptata = generatePassword(elev);
            logger.info("Parola generată pentru elev: {}", parolaNecriptata);
            emailService.sendEmail(elev.getEmailElev(), "Parola ta", "Parola ta este: " + parolaNecriptata);
        } else {
            logger.warn("Elevul cu matricolul {} nu a fost găsit.", matricol);
            throw new RuntimeException("Elevul nu a fost găsit.");
        }
    }
    @Autowired
    public ElevService(ElevRepository elevRepository) {
        this.elevRepository = elevRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Iterable<ElevModel> findAllElevi() {
        return elevRepository.findAll();
    }

    public boolean verificaParola(String matricol, String parolaIntroducere) {
        Optional<ElevModel> optionalElev = elevRepository.findById(matricol);
        if (optionalElev.isPresent()) {
            ElevModel elev = optionalElev.get();
            System.out.println(elev.getMatricol());
            System.out.println(parolaIntroducere);
            return passwordEncoder.matches(parolaIntroducere, elev.getParola());

        }
        return false;
    }
    public Optional<ElevModel> findElevByMatricol(String matricol) {
        return elevRepository.findById(matricol);
    }

    private static final Logger logger = LoggerFactory.getLogger(ElevService.class);
    public void addElev(ElevModel elev) {
        if (elevRepository.existsById(elev.getMatricol())) {
            logger.warn("Elevul există deja cu matricolul: {}", elev.getMatricol());
            throw new RuntimeException("Elevul există deja. Nu se poate adăuga.");
        }

        logger.info("Adăugăm elevul cu matricolul: {}", elev.getMatricol());
        String generatedPassword = generatePassword(elev);
        System.out.println("Parola este " + generatedPassword);
        String encryptedPassword = passwordEncoder.encode(generatedPassword);
        elev.setParola(encryptedPassword);

        // Apelăm metoda insert
        elevRepository.insertElev(elev.getMatricol(), elev.getNume(), elev.getPrenume(), elev.getCnp(),elev.getEmailElev(), elev.getDenumireScoala(), elev.getParola());
    }



    private String generatePassword(ElevModel elev) {
        String prenumeInitial = elev.getPrenume().substring(0, 1).toUpperCase();
        String numeLitere = elev.getNume().substring(0, 2).toUpperCase();
        String cnpLast4 = elev.getCnp().substring(0,4);
        String scoalaLitere = elev.getDenumireScoala().substring(0, 2).toUpperCase();

        // Construim parola combinând elementele alese
        return prenumeInitial + numeLitere + cnpLast4 + scoalaLitere ;
    }
    public void deleteElev(String matricol) {
        elevRepository.deleteById(matricol);
    }

    public void updateElev(String matricol, ElevModel elev) {
        Optional<ElevModel> oldElev = elevRepository.findById(matricol);
        if (oldElev.isPresent()) {
            ElevModel updatedElev = oldElev.get();
            updatedElev.setNume(elev.getNume());
            updatedElev.setPrenume(elev.getPrenume());
            updatedElev.setCnp(elev.getCnp());
            updatedElev.setEmailElev(elev.getEmailElev());
            updatedElev.setDenumireScoala(elev.getDenumireScoala());


            String generatedPassword = generatePassword(elev);
            updatedElev.setParola(generatedPassword);

            elevRepository.save(updatedElev);
        } else {

            throw new RuntimeException("Elevul cu matricolul " + matricol + " nu există.");
        }
    }

}


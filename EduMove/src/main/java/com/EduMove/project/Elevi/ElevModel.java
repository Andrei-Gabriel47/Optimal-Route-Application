package com.EduMove.project.Elevi;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "elevi")
public class ElevModel {

    @Id
    @Column("matricol")
    private String matricol;

    @Column("nume_elev")
    private String nume;

    @Column("prenume_elev")
    private String prenume;

    @Column("cnp")
    private String cnp;

    @Column("email_elev")
    private String emailElev;

    @Column("denumire_scoala")
    private String denumireScoala;

    @Column("parola")
    private String parola;

    // Getters și Setters
    public String getMatricol() {
        return matricol;
    }

    public void setMatricol(String matricol) {
        this.matricol = matricol;
    }

    public String getEmailElev() {
        return emailElev;
    }

    public void setEmailElev(String emailElev) {
        this.emailElev = emailElev;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getDenumireScoala() {
        return denumireScoala;
    }

    public void setDenumireScoala(String denumireScoala) {
        this.denumireScoala = denumireScoala;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}


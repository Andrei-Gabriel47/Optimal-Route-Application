package com.EduMove.project.Parinti;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "parinti")
public class ParinteModel {

    @Id
    @Column("email_parinte")
    private String email;

    @Column("matricol_copil")
    private String matricolCopil;

    @Column("nume_parinte")
    private String numeParinte;

    @Column("prenume_parinte")
    private String prenumeParinte;

    @Column("cnp")
    private String cnp;

    @Column("parola")
    private String parola;

    // Getters și Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricolCopil() {
        return matricolCopil;
    }

    public void setMatricolCopil(String matricolCopil) {
        this.matricolCopil = matricolCopil;
    }

    public String getNumeParinte() {
        return numeParinte;
    }

    public void setNumeParinte(String numeParinte) {
        this.numeParinte = numeParinte;
    }

    public String getPrenumeParinte() {
        return prenumeParinte;
    }

    public void setPrenumeParinte(String prenumeParinte) {
        this.prenumeParinte = prenumeParinte;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}


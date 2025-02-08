package com.EduMove.project.Soferi;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "soferi")
public class SoferModel {

    @Id
    @Column("id_sofer")
    private String idSofer;

    @Column("nume_sofer")
    private String nume;

    @Column("prenume_sofer")
    private String prenume;

    @Column("cnp_sofer")
    private String cnp;

    @Column("parola")
    private String parola;

    // Getters și Setters
    public String getIdSofer() {
        return idSofer;
    }

    public void setIdSofer(String idSofer) {
        this.idSofer = idSofer;
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}

package com.EduMove.project.Rezervari;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "rezervari")
public class RezervareModel {

    @Id
    @Column
    private String id_rezervare;

    @Column("matricol")
    private String matricol;


    @Column("id_statie")
    private String id_statie;


    @Column("data_rezervare")
    private Date data_rezervare;

    // Getters și Setters
    public String getMatricol() {
        return matricol;
    }

    public void setMatricol(String matricol) {
        this.matricol = matricol;
    }

    public String getId_rezervare() {
        return id_rezervare;
    }

    public void setId_rezervare(String id_rezervare) {
        this.id_rezervare = id_rezervare;
    }
    public String getId_statie() {
        return id_statie;
    }

    public void setId_statie(String id_statie) {
        this.id_statie = id_statie;
    }

    public Date getData_rezervare() {
        return data_rezervare;
    }

    public void setData_rezervare(Date data_rezervare) {
        this.data_rezervare = data_rezervare;
    }
}

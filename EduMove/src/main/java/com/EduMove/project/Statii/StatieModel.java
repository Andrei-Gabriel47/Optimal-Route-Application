package com.EduMove.project.Statii;

import com.EduMove.project.Traseu.TraseuService;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "statii")
public class StatieModel {

    @Id
    @Column("id_statie")
    private String idStatie;

    @Column("nume_statie")
    private String numeStatie;

    @Column("latitudine")
    private double latitudine;

    @Column("longitudine")
    private double longitudine;


    // Getters și Setters
    public String getIdStatie() {
        return idStatie;
    }

    public void setIdStatie(String idStatie) {
        this.idStatie = idStatie;
    }

    public String getNumeStatie() {
        return numeStatie;
    }

    public void setNumeStatie(String numeStatie) {
        this.numeStatie = numeStatie;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }
}

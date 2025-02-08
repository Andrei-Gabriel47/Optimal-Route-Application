package com.EduMove.project.Rezervari;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface RezervareRepository extends CrudRepository<RezervareModel, String> {
    @Modifying
    @Query("INSERT INTO rezervari (id_rezervare , matricol, id_statie, data_rezervare) " +
            "VALUES (:id_rezervare, :matricol, :id_statie, :data_rezervare)")
    void insertRezervare( @Param("id_rezervare") String id_rezervare,
                @Param("matricol") String matricol,
                    @Param("id_statie") String id_statie,
                    @Param("data_rezervare") Date data_rezervare);

}

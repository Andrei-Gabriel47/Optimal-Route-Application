package com.EduMove.project.Statii;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatieRepository extends CrudRepository<StatieModel, String> {
    @Query("SELECT s.* FROM statii s " +
            "JOIN rezervari r ON s.id_statie = r.id_statie " +
            "WHERE r.data_rezervare = :dataRezervare")
    List<StatieModel> findStationsForReservationsOnDate(@Param("dataRezervare") Date dataRezervare);

}

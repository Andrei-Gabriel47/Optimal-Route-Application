package com.EduMove.project.Elevi;



import com.EduMove.project.Elevi.ElevModel;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevRepository extends CrudRepository<ElevModel, String> {
    @Modifying
    @Query("INSERT INTO elevi (matricol, nume_elev, prenume_elev, CNP, email_elev, denumire_scoala, parola) " +
            "VALUES (:matricol, :nume, :prenume, :cnp, :email_elev, :denumireScoala, :parola)")
    void insertElev(@Param("matricol") String matricol,
                    @Param("nume") String nume,
                    @Param("prenume") String prenume,
                    @Param("cnp") String cnp,
                    @Param("email_elev") String emailElev,
                    @Param("denumireScoala") String denumireScoala,
                    @Param("parola") String parola);

}


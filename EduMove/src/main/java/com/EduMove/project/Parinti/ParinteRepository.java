package com.EduMove.project.Parinti;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParinteRepository extends CrudRepository<ParinteModel, String> {
}

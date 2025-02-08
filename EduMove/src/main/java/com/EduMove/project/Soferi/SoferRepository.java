package com.EduMove.project.Soferi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoferRepository extends CrudRepository<SoferModel, String> {
}

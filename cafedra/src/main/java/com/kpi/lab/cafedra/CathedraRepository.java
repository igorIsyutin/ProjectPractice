package com.kpi.lab.cafedra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CathedraRepository extends CrudRepository<Cathedra, Integer> {
}

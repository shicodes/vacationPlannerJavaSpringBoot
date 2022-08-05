package com.springframework.springboot.repositories;

import com.springframework.springboot.domain.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends CrudRepository<Vacation,Long> {
}

package com.accsoftware.rest.incomes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomesRepository extends JpaRepository<Incomes, Long> {
	
}

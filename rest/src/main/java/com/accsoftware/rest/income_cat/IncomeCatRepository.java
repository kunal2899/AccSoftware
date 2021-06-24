package com.accsoftware.rest.income_cat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCatRepository extends JpaRepository<IncomeCat, Long> {
	public List<IncomeCat> findAllByUserId(Long userId);
}

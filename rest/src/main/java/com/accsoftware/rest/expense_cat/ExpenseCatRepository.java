package com.accsoftware.rest.expense_cat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCatRepository extends JpaRepository<ExpenseCat, Long>{
	public List<ExpenseCat> findAllByUserId(Long userId);
}

package com.accsoftware.rest.expenses;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	public List<Expenses> findAllByUserIdAndPaybyAndDateBetween(Long uid, String pb,Date startDate, Date endDate);
	public List<Expenses> findAllByUserIdAndDateBetween(Long uid, Date start, Date end);
}

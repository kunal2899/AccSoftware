package com.accsoftware.rest.incomes;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IncomesRepository extends JpaRepository<Incomes, Long> {
	public List<Incomes> findAllByUserIdAndRecievebyAndDateBetween(Long uid,String rb,Date startDate, Date endDate);
	public List<Incomes> findAllByUserIdAndDateBetween(Long uid, Date start, Date end);
}

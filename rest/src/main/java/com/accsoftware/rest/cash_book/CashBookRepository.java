package com.accsoftware.rest.cash_book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashBookRepository extends JpaRepository<CashBook, Long> {
	public List<CashBook> findByOrderByDate();
}

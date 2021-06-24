package com.accsoftware.rest.cash_book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashBookService {
	
	@Autowired
	CashBookRepository cr;
	
	public List<CashBook> getAll(){
		return cr.findByOrderByDate();
	}
}

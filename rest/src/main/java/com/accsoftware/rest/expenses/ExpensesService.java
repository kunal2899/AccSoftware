package com.accsoftware.rest.expenses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExpensesService {

	@Autowired
	ExpensesRepository er;
	
	public List<Expenses> getAll(){
		return er.findAll();
	}
	
	public Optional<Expenses> get(Long Id) {
		return er.findById(Id);
	}
	
	public void create(Expenses e) {
		er.save(e);
	}
	
	public void update(Expenses e) {
		er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}
}

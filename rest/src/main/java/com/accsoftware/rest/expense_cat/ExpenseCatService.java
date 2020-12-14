package com.accsoftware.rest.expense_cat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseCatService {

	@Autowired
	ExpenseCatRepository er;
	
	public List<ExpenseCat> getAll(){
		return er.findAll();
	}
	
	public Optional<ExpenseCat> get(Long Id) {
		return er.findById(Id);
	}
	
	public Long create(ExpenseCat e) {
		e = er.save(e);
		return e.getId();
	}
	
	public ExpenseCat update(ExpenseCat e) {
		return er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}
	
	public List<ExpenseCat> getAll(Long userId){
		return er.findAllByUserId(userId);
	}
}

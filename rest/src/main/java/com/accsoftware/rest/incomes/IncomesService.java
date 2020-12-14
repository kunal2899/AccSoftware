package com.accsoftware.rest.incomes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IncomesService {

	@Autowired
	IncomesRepository er;
	
	public List<Incomes> getAll(){
		return er.findAll();
	}
	
	public Incomes get(Long Id) {
		Optional<Incomes> o = er.findById(Id);
		return o.get();
	}
	
	public void create(Incomes e) {
		er.save(e);
	}
	
	public void update(Incomes e) {
		er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}
}

package com.accsoftware.rest.income_cat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IncomeCatService {
	
	@Autowired
	IncomeCatRepository er;
	
	public List<IncomeCat> getAll(){
		return er.findAll();
	}
	
	public IncomeCat get(Long Id) {
		Optional<IncomeCat> o = er.findById(Id);
		return o.get();
	}
	
	public void create(IncomeCat e) {
		er.save(e);
	}
	
	public void update(IncomeCat e) {
		er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}

}

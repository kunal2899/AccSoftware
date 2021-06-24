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
	
	public List<IncomeCat> getAll(Long uid){
		return er.findAllByUserId(uid);
	}
	
	public Optional<IncomeCat> get(Long Id) {
		 return er.findById(Id);
	}
	
	public Long create(IncomeCat e) {
		er.save(e);
		return e.getId();
	}
	
	public IncomeCat update(IncomeCat e) {
		return er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}

}

package com.accsoftware.rest.incomes;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;




@Service
public class IncomesService {

	@Autowired
	IncomesRepository er;
	
	public List<Incomes> getAll(){
		return er.findAll();
	}
	
	public Optional<Incomes> get(Long Id) {
		return er.findById(Id);
	}
	
	public List<Incomes> getByRange(Long uid,String rb,Date s, Date e){
		return er.findAllByUserIdAndRecievebyAndDateBetween(uid,rb,s, e);
	}
	
	public List<Incomes> getInRange(Long uid, Date s, Date e){
		return er.findAllByUserIdAndDateBetween(uid,s, e);
	}
	
	public void create(Incomes e) {
		er.save(e);
	}
	
	public Incomes update(Incomes e) {
		return er.save(e);
	}
	
	public void remove(Long Id) {
		er.deleteById(Id);
	}
	
	public Date toDate(String str) {
		Locale locale = new Locale("EN","INDIA");
		DateFormatter df = new DateFormatter("yyyy-MM-dd");
		Date s = new Date();
		try {
			s = df.parse(str, locale);
		} catch(Exception exp) {}
		return s;
	}
}

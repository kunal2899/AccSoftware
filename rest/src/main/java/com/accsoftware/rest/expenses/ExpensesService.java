package com.accsoftware.rest.expenses;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;


@Service
public class ExpensesService {

	@Autowired
	ExpensesRepository er;
	
	public List<Expenses> getAll(){
		return er.findAll();
	}
	
	public List<Expenses> getByRange(Long uid,String pb,Date s, Date e){
		return er.findAllByUserIdAndPaybyAndDateBetween(uid,pb,s, e);
	}
	
	public List<Expenses> getInRange(Long uid, Date s, Date e){
		return er.findAllByUserIdAndDateBetween(uid,s, e);
	}
	
	public Optional<Expenses> get(Long Id) {
		return er.findById(Id);
	}
	
	public void create(Expenses e) {
		er.save(e);
	}
	
	public Expenses update(Expenses e) {
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

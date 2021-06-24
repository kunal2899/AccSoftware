package com.accsoftware.rest.incomes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accsoftware.rest.income_cat.IncomeCat;
import com.accsoftware.rest.income_cat.IncomeCatService;


@CrossOrigin("http://localhost:4200")
@RestController
public class IncomesController {

	@Autowired
	IncomesService es;
	
	@Autowired
	IncomeCatService ics;
	
	@PostMapping("/incomes")
	public void createIncome(@RequestBody IncomeDTO e) {
		Incomes i = e.getIncome();
		Optional<IncomeCat> o = ics.get(e.getIncCatId());
		i.setIc(o.get());
		es.create(i);
	}
	
	@GetMapping("/{uid}/incomes/{start}/{end}")
	public List<Incomes> getInRange(@PathVariable Long uid, @PathVariable String start, @PathVariable String end){
		return es.getInRange(uid, es.toDate(start), es.toDate(end));
	}
	
	@GetMapping("/{uid}/incomes/{pb}/{start}/{end}")
	public List<Incomes> getByRange(@PathVariable Long uid ,@PathVariable String pb ,@PathVariable String start, @PathVariable String end){
		return es.getByRange(uid,pb,es.toDate(start), es.toDate(end));
	}
	
	@PutMapping("/incomes")
	public ResponseEntity<?> updateIncome(@RequestBody IncomeDTO e) {
		Incomes i = e.getIncome();
		Optional<IncomeCat> o = ics.get(e.getIncCatId());
		i.setIc(o.get());
		es.update(i);
		return new ResponseEntity<Incomes>(i,HttpStatus.OK);
	}
	
	@GetMapping("/incomes")
	public List<Incomes> getAllIncomes() {
		return es.getAll();
	}
	
	@GetMapping("/incomes/{id}")
	public ResponseEntity<?> getIncome(@PathVariable Long id) {
		Optional<Incomes> o = es.get(id);
		if(o.isPresent()) {
			return new ResponseEntity<Incomes>(o.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Income you requested is not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/incomes/{id}")
	public void removeIncome(@PathVariable Long id) {
		es.remove(id);
	}
}

package com.accsoftware.rest.incomes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IncomesController {

	@Autowired
	IncomesService es;
	
	@PostMapping("/incomes")
	public void createIncome(@RequestBody Incomes e) {
		es.create(e);
	}
	
	@PutMapping("/incomes")
	public void updateIncome(@RequestBody Incomes e) {
		es.update(e);
	}
	
	@GetMapping("/incomes")
	public List<Incomes> getAllIncomes() {
		return es.getAll();
	}
	
	@GetMapping("/incomes/{id}")
	public Incomes getIncome(@PathVariable Long id) {
		return es.get(id);
	}
	
	@DeleteMapping("/incomes/{id}")
	public void removeIncome(@PathVariable Long id) {
		es.remove(id);
	}
}

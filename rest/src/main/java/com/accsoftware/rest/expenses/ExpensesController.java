package com.accsoftware.rest.expenses;

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

import com.accsoftware.rest.expense_cat.ExpenseCat;
import com.accsoftware.rest.expense_cat.ExpenseCatService;

@CrossOrigin("http://localhost:4200")
@RestController
public class ExpensesController {

	@Autowired
	ExpensesService es;
	
	@Autowired
	ExpenseCatService ecs;
	
	@PostMapping("/expenses")
	public void createExpense(@RequestBody ExpensesDTO edto) {
		Expenses e = edto.getExpense();
		Optional<ExpenseCat> o = ecs.get(edto.getExpCatId());
		e.setEc(o.get());
		es.create(e);
	}
	
	@PutMapping("/expenses")
	public ResponseEntity<?> updateExpense(@RequestBody ExpensesDTO edto) {
		Expenses e = edto.getExpense();
		Optional<ExpenseCat> o = ecs.get(edto.getExpCatId());
		e.setEc(o.get());
		es.update(e);
		return new ResponseEntity<Expenses>(e,HttpStatus.OK);
	}
	
	@GetMapping("/expenses")
	public List<Expenses> getAllExpenses() {
		return es.getAll();
	}
	
	@GetMapping("/expenses/{id}")
	public ResponseEntity<?> getExpense(@PathVariable Long id) {
		Optional<Expenses> o = es.get(id);
		if(o.isPresent()) {
			return new ResponseEntity<Expenses>(o.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Expense you requested is not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<?> removeExpense(@PathVariable Long id) {
		es.remove(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

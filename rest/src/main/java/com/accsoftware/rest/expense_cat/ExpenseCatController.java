package com.accsoftware.rest.expense_cat;

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

@CrossOrigin("http://localhost:4200")
@RestController
public class ExpenseCatController {

	@Autowired
	ExpenseCatService es;
	
	@PostMapping("/expense-cat")
	public void createCategory(@RequestBody ExpenseCat e) {
		es.create(e);
//		return id;
//		return new ResponseEntity<String>("New entry created with id : "+id ,HttpStatus.CREATED);
	}
	
	@PutMapping("/expense-cat")
	public ResponseEntity<?> updateCategory(@RequestBody ExpenseCat e) {
		e = es.update(e);
		return new ResponseEntity<ExpenseCat>(e,HttpStatus.OK);
	}
	
	@GetMapping("/expense-cat")
	public List<ExpenseCat> getAllCategories() {
		return es.getAll();
	}
	
	@GetMapping("users/{uid}/expense-cat")
	public List<ExpenseCat> getAllByUserId(@PathVariable Long uid){
		return es.getAll(uid);
	}
	
	@GetMapping("/expense-cat/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Long id) {
		Optional<ExpenseCat> o = es.get(id);
		if(o.isPresent()) 
			return new ResponseEntity<ExpenseCat>(o.get(),HttpStatus.OK);
		else
			return new ResponseEntity<String>("Expense Category not found",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/expense-cat/{id}")
	public ResponseEntity<?> removeCategory(@PathVariable Long id) {
		es.remove(id);
		return new ResponseEntity<String>("Expense category deleted successfully",HttpStatus.NO_CONTENT); 
	}
}

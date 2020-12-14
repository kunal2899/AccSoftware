package com.accsoftware.rest.income_cat;

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
public class IncomeCatController {

	@Autowired
	IncomeCatService es;
	
	@PostMapping("/income-cat")
	public void createCategory(@RequestBody IncomeCat e) {
		es.create(e);
	}
	
	@PutMapping("/income-cat")
	public void updateCategory(@RequestBody IncomeCat e) {
		es.update(e);
	}
	
	@GetMapping("/income-cat")
	public List<IncomeCat> getAllCategories() {
		return es.getAll();
	}
	
	@GetMapping("/income-cat/{id}")
	public IncomeCat getCategory(@PathVariable Long id) {
		return es.get(id);
	}
	
	@DeleteMapping("/income-cat/{id}")
	public void removeCategory(@PathVariable Long id) {
		es.remove(id);
	}
}

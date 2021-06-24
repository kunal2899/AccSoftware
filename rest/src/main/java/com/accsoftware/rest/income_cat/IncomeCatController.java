package com.accsoftware.rest.income_cat;

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
public class IncomeCatController {

	@Autowired
	IncomeCatService es;
	
	@PostMapping("/income-cat")
	public void createCategory(@RequestBody IncomeCat e) {
		es.create(e);
	}
	
	@PutMapping("/income-cat")
	public ResponseEntity<?> updateCategory(@RequestBody IncomeCat e) {
		e = es.update(e);
		return new ResponseEntity<IncomeCat>(e,HttpStatus.OK);
	}
	
	@GetMapping("/income-cat")
	public List<IncomeCat> getAllCategories() {
		return es.getAll();
	}
	
	@GetMapping("users/{uid}/income-cat")
	public List<IncomeCat> getAllByUserId(@PathVariable Long uid){
		return es.getAll(uid);
	}
	
	@GetMapping("/income-cat/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Long id) {
		Optional<IncomeCat> o = es.get(id);
		if(o.isPresent()) {
			return new ResponseEntity<IncomeCat>(o.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Income Category not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/income-cat/{id}")
	public ResponseEntity<?> removeCategory(@PathVariable Long id) {
		es.remove(id);
		return new ResponseEntity<String>("Income category deleted successfully",HttpStatus.NO_CONTENT);
	}
}

package com.backend.inventree.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.inventree.models.Product;
import com.backend.inventree.services.ProductService;


@RestController
@RequestMapping("/api/auth")
public class ProductController {
	
	@Autowired
	public ProductService service;
	
	@GetMapping("/all")
	@CrossOrigin(origins="http://localhost:4200")
	private Iterable<Product> viewAll(){
		return service.viewAll();
	}
	
	@GetMapping("/view/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	private Optional<Product> viewById(@PathVariable String id){
		return service.find(id);
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins="http://localhost:4200")
	private void addProduct(@RequestBody Product product ){
		service.insert(product);
	}
	
	@DeleteMapping("/del/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	private void deleteProduct(@PathVariable String id) {		
		service.deleteProduct(id);
	}
	
	@PutMapping("/edit/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	private void edit(@PathVariable String id,@RequestBody Product product) {
		service.editProduct(id, product);
	}

}

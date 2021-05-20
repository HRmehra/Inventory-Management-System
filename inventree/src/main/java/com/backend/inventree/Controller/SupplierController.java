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

import com.backend.inventree.models.Suppliers;
import com.backend.inventree.services.SupplierService;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:4200")
public class SupplierController {
	
	@Autowired 
	private SupplierService service;
	
	@PostMapping("/addSup")
	public void add(@RequestBody Suppliers sups) {
		service.addS(sups);
	}
	
	@GetMapping("/showSup")
	public Iterable<Suppliers> showAll() {
		return service.showAll();
		
	}
	@GetMapping("/viewsup/{sno}")
	private Optional<Suppliers> viewById(@PathVariable String sno){
		return service.findsup(sno);
	}
	
	@DeleteMapping("/delSup/{sno}")
	public void deleteS(@PathVariable String sno) {
		service.deleteSupp(sno);
	}
	
	@PutMapping("/editsup/{sno}")
	private void edit(@PathVariable String sno,@RequestBody Suppliers suppliers) {
		service.editSupplier(sno, suppliers);
	}
	

}

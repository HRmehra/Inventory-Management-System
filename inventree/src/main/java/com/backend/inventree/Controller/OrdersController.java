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

import com.backend.inventree.models.Orders;
import com.backend.inventree.services.OrdersService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:4200")
public class OrdersController {
	@Autowired
	private OrdersService service;
	
	@PostMapping("/addord")
	public void add(@RequestBody Orders orders) {
		service.add(orders);
	}
	
	@GetMapping("/showord")
	public Iterable<Orders> showall(){
		return service.getAll();
	}
	
	@GetMapping("/vieword/{id}")
	private Optional<Orders> viewById(@PathVariable String id){
		return service.find(id);
	}
	
	@PutMapping("editord/{id}")
	private void edit(@PathVariable String id,@RequestBody Orders orders) {
		service.editOrders(id, orders);
	}
	
	@DeleteMapping("delord/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	private void deleteOrders(@PathVariable String id) {		
		service.deleteOrders(id);
	}

}

package com.backend.inventree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.inventree.models.Users;
import com.backend.inventree.services.UsersService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:4200")
public class UsersController {
	
	@Autowired
	UsersService service;
	
	@GetMapping("/getUsers")
	public Iterable<Users> showAll(){
		return service.findall();
	}
	
	@DeleteMapping("/delUser{id}")
	public void delete(@PathVariable String id ,@RequestBody Users user) {
		service.deleteUser(id, user);
	}
}

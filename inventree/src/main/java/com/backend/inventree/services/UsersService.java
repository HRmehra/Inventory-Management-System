package com.backend.inventree.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.inventree.Repository.UsersRepository;
import com.backend.inventree.models.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository uRepo;
	
	public Iterable<Users> findall(){
		return uRepo.findAll();
	}
	
	public Users deleteUser(String id,Users user) {
		Optional<Users> oUser = this.uRepo.findById(id);
		if(oUser.isPresent()) {
			Users delUser =oUser.get();
			this.uRepo.delete(delUser);
			return delUser;
		}
		return null;
	}

}

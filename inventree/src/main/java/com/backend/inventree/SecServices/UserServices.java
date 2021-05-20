package com.backend.inventree.SecServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.inventree.Repository.UsersRepository;
import com.backend.inventree.models.Users;


@Service
public class UserServices implements UserDetailsService {
	@Autowired
	UsersRepository uRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = uRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "
		+ username));

		return UserImpl.build(users);
	}
}

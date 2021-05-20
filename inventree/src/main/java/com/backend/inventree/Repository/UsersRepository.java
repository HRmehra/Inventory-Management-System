package com.backend.inventree.Repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.backend.inventree.models.Users;


public interface UsersRepository extends MongoRepository<Users, String> {
	Optional<Users> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}

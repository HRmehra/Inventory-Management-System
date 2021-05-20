package com.backend.inventree.Repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.inventree.models.Role;
import com.backend.inventree.models.roleEnum;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {
	 Optional<Role> findByName(roleEnum name);
}

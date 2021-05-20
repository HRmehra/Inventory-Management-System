package com.backend.inventree.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.inventree.models.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,String>{
	
	public Optional<Product> findById(String id);
}

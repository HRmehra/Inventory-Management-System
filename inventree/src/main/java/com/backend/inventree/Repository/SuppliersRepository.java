package com.backend.inventree.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.inventree.models.Suppliers;


@Repository
public interface SuppliersRepository  extends MongoRepository<Suppliers, String>{

}

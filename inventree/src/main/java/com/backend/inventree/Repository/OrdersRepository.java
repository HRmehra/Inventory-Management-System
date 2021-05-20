package com.backend.inventree.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.inventree.models.Orders;


@Repository
public interface OrdersRepository extends MongoRepository<Orders,String> {
	

}

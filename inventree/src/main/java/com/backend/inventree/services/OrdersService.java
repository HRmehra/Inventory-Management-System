package com.backend.inventree.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.inventree.Repository.OrdersRepository;
import com.backend.inventree.models.Orders;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository oRepo;
	
	public void add(Orders orders) {
		oRepo.save(orders);
	}
	
	public Iterable<Orders> getAll() {
		return oRepo.findAll();
	}
	public Optional<Orders> find(String id){
		return oRepo.findById(id);
	}

	public void editOrders(String id,Orders orders) {
		Optional<Orders> oObj =this.oRepo.findById(id);
		if(oObj.isPresent()) {
			Orders oEdit =oObj.get();
			oEdit.setName(orders.getName());
			oEdit.setQuantity(orders.getQuantity());
			oEdit.setPrice(orders.getPrice());
			
			this.oRepo.save(oEdit);
		}

	}

	public Orders deleteOrders(String id ) {
		Optional<Orders> dOdd =this.oRepo.findById(id);
		if(dOdd.isPresent()) {
			Orders oDel =dOdd.get();
		this.oRepo.delete(oDel);	
		return oDel;
		}
		return null;
	}

}

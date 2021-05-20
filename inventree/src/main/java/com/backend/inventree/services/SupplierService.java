package com.backend.inventree.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.inventree.Repository.SuppliersRepository;
import com.backend.inventree.models.Suppliers;


@Service

public class SupplierService {
	@Autowired
	private SuppliersRepository sRepo;
	
	
	public void addS(Suppliers sups) {
		//sups.setSno(sServ.getSequence(Suppliers.SEQUENCE_NAME));
		sRepo.save(sups);	
	}
	
	public Iterable<Suppliers>showAll(){
		return sRepo.findAll();
	}
	
	public Optional<Suppliers> findsup(String sno){
		return sRepo.findById(sno);
	}
	
	public Suppliers deleteSupp(String sno ) {
		Optional<Suppliers> dOpt =this.sRepo.findById(sno);
		if(dOpt.isPresent()) {
			Suppliers sDel =dOpt.get();
		this.sRepo.delete(sDel);	
		return sDel;
		}
		return null;
	}

	public void editSupplier(String sno,Suppliers supplier) {
		Optional<Suppliers> sEdt=this.sRepo.findById(sno);
		if(sEdt.isPresent()) {
			Suppliers sEdit =sEdt.get();
			sEdit.setSname(supplier.getSname());
			sEdit.setContactNo(supplier.getContactNo());
			sEdit.setEmail(supplier.getEmail());
			sEdit.setAddress(supplier.getAddress());
			sEdit.setCity(supplier.getCity());
	
			this.sRepo.save(sEdit);
		}
		
	}

}

package com.backend.inventree.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.inventree.Repository.ProductRepository;
import com.backend.inventree.models.Product;


@Service
public class ProductService {
	
	@Autowired 
	ProductRepository pRepo;
	
	public Product insert(Product prod) {
		//prod.setId(sService.getSequence(Product.SEQUENCE_NAME));
		return pRepo.save(prod);
		}
	
	public Iterable<Product> viewAll() {
		return pRepo.findAll();
	}
	
	public Optional<Product> find(String id){
		return pRepo.findById(id);
	}
	
	public Product deleteProduct(String id ) {
		Optional<Product> dOpt =this.pRepo.findById(id);
		if(dOpt.isPresent()) {
			Product pDel =dOpt.get();
		this.pRepo.delete(pDel);	
		return pDel;
		}
		return null;
	}
	
	public void editProduct(String id,Product product) {
		Optional<Product> pOpt =this.pRepo.findById(id);
		if(pOpt.isPresent()) {
			Product pEdit =pOpt.get();
			pEdit.setProductName(product.getProductName());
			pEdit.setQuantity(product.getQuantity());
			pEdit.setBuyingPrice(product.getBuyingPrice());
			pEdit.setSellingPrice(product.getSellingPrice());
			
			this.pRepo.save(pEdit);
		}
		
	}

}

package com.backend.inventree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
	@Id
	private String id;
	private String productName;
	private String brand;
	private int quantity;
	private int buyingPrice;
	private int sellingPrice;
	
	public Product() {
	}
	
	public Product(String id, String productName,String brand, int quantity, int buyingPrice , int sellingPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.setBrand(brand);
		this.quantity = quantity;
		this.buyingPrice = buyingPrice;
		this.sellingPrice= sellingPrice;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


}

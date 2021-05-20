package com.backend.inventree.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")

public class Orders {
	
	@Id
	private String oId;
	private String name;
	private int quantity;
	private int price;
	private String oSupplier;
	private Date deadline;
	
	public Orders() {
	}
	
	public Orders(String oId, String name, int quantity, int price,String oSupplier, Date deadline) {
		super();
		this.oId = oId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.oSupplier=oSupplier;
		this.deadline=deadline;
	}
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getoSupplier() {
		return oSupplier;
	}

	public void setoSupplier(String oSupplier) {
		this.oSupplier = oSupplier;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
}

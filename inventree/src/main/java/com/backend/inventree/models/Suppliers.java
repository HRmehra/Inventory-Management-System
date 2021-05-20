package com.backend.inventree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="suppliers")
public class Suppliers {
	
	@Id
	private String sno;
	private String sname;
	private long contactNo;
	private String email;
	private String address;
	private String city;
	
	public Suppliers() {
	}
	
	public Suppliers(String sno, String sname, long contactNo,String email, String address, String city) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.contactNo = contactNo;
		this.email=email;
		this.address=address;
		this.city = city;
	}

	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}	
	public String getEmail() {
		return email;
	}	
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


}

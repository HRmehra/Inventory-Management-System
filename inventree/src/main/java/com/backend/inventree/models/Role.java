package com.backend.inventree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
	
	@Id
	  private String id;
	  private roleEnum name;

	  public Role() {
	  }

	  public Role(roleEnum name) {
	    this.name = name;
	  }
	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }
	  public roleEnum getName() {
	    return name;
	  }
	  public void setName(roleEnum name) {
	    this.name = name;
	  }
}

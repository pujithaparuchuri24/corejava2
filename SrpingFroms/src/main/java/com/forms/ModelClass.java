package com.forms;

import javax.validation.constraints.Size;

public class ModelClass{

	@Size(min=1,message = "Name cannot be null")
	
	private String name;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", email=" + email + "]";
	}


}

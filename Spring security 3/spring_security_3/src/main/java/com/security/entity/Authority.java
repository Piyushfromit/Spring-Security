package com.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Authority {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String email;
	private String authority;
	
	
	public Authority() {
		// TODO Auto-generated constructor stub
	}


	public Authority(int id, String email, String authority) {
		super();
		this.id = id;
		this.email = email;
		this.authority = authority;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
	
	
	
	
	
	
	

}

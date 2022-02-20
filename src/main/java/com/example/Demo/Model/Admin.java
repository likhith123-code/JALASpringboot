package com.example.Demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	String userrname;
	String password;
	
	public Admin() {
		
	}
	
	public Admin(String userrname, String password) {
		super();
		this.userrname = userrname;
		this.password = password;
	}
	public String getUserrname() {
		return userrname;
	}
	public void setUserrname(String userrname) {
		this.userrname = userrname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

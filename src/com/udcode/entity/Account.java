package com.udcode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_account")
public class Account {

	private String email;

	private String password;

	private long id;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	@Column(name="email",length=50)
	public String getEmail() {
		return email;
	}

	@Column(name="password",length=50)
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
	}

}

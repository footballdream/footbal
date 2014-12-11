package com.udcode.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="t_team")
public class Team {

	private int id;
	
	private String name;
	
	private String createTime;

	private Field homeField;
	
	private Account account;
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)  
	public Field getHomeField() {
		return homeField;
	}

	public void setHomeField(Field homeField) {
		this.homeField = homeField;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@OneToOne(fetch=FetchType.LAZY)
	public Account getAccount() {
		return account;
	}

	
	public void setAccount(Account account) {
		this.account = account;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name",length=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="create_time",length=50)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}

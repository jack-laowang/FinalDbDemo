package com.devchina.ormdemo;

import net.tsz.afinal.annotation.sqlite.Table;

@Table(name="OneBO")
public class OneBO {
	
	private int id;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOneString() {
		return OneString;
	}
	public void setOneString(String oneString) {
		OneString = oneString;
	}
	private String OneString;

	
	
	
}

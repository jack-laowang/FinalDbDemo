package com.devchina.ormdemo;

import net.tsz.afinal.annotation.sqlite.Table;

@Table(name="ThreeBO")
public class ThreeBO {

	private int id;
	private int userId;
	private String ThreeString;
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
	public String getThreeString() {
		return ThreeString;
	}
	public void setThreeString(String threeString) {
		ThreeString = threeString;
	}
	
}

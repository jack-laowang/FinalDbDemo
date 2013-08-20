package com.devchina.ormdemo;

import net.tsz.afinal.annotation.sqlite.Table;

@Table(name="TwoBO")
public class TwoBO {
	private int id;
	private int userId;
	private String TwoString;
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
	public String getTwoString() {
		return TwoString;
	}
	public void setTwoString(String twoString) {
		TwoString = twoString;
	}

}

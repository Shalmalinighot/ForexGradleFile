package com.sprint.forex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Verification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String userName;
	String Otp;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOtp() {
		return Otp;
	}
	public void setOtp(String otp) {
		Otp = otp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
package com.sprint.forex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminVerification {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;

String Otp;
String adminEmail;



public int getId() {
return id;
}
public void setId(int id) 
{
	this.id = id;
	}
public String getOtp() {
return Otp;
}
public void setOtp(String otp) {
this.Otp = otp;
}
public String getAdminEmail() {
	return adminEmail;
}
public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}


	}








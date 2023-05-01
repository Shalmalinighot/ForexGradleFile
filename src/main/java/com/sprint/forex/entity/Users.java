package com.sprint.forex.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Table(name="users")
@Entity
public class Users {
	
	@Id
	@Column(name = "users_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usersId;
	
	@Column(name = "name")
	private String name;
	

	
	@Column(name = "location")
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	private String mobileNo;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL )
    @JsonIgnore
	private List<UserBankDetails> userbankdetails;

//	@OneToMany(mappedBy="user")
//    @JsonIgnore
//	private List<Transaction> transaction;

	public List<UserBankDetails> getUserbankdetails() {
		return userbankdetails;
	}
	public void setUserbankdetails(List<UserBankDetails> userbankdetails) {
		this.userbankdetails = userbankdetails;
	}
	
	





	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}

package com.sprint.forex.dto;

import javax.validation.constraints.NotNull;

public class UsersDto {

	private int usersId;

	@NotNull(message = "name is required")
	private String name;

	@NotNull(message = "Location Name is required")
	private String location;

	@NotNull(message = "Gender Name is required")
	private String gender;

	@NotNull(message = "email Name is required")
	private String email;

	@NotNull(message = "password Name is required")
	private String password;

	@NotNull(message = "MobileNo is required")
	private String mobileNo;

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

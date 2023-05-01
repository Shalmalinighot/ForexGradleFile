package com.sprint.forex.service;

import com.sprint.forex.entity.Users;

public interface UsersAuthenticationService {
	
	public Users login(String email, String password);
	
	
	public String sendEmail(String toEmail);
	public String verifyOtp(String email,String otp);
	public String verifyEmail(String email);

}
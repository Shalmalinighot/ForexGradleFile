package com.sprint.forex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.LoginDto;
import com.sprint.forex.entity.Users;

import com.sprint.forex.service.UsersAuthenticationService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/auth")
public class UsersAuthenticationController {
	@Autowired
	private UsersAuthenticationService usersAuthenticationService;

	@PostMapping("/login")
	public ResponseEntity<Users> doLogin(@RequestBody LoginDto loginReq) {
		Users users = usersAuthenticationService.login(loginReq.getEmail(), loginReq.getPassword());
		ResponseEntity<Users> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/sendEmail/{toEmail}")
	public String sendEmail(@PathVariable("toEmail") String toEmail) {
		return usersAuthenticationService.sendEmail(toEmail);
		}
	
	
	@DeleteMapping("/verify/{email}/{otp}")
	public String Verifyotp(@PathVariable("email")String email,@PathVariable("otp") String otp)
	{
		return usersAuthenticationService.verifyOtp(email, otp);
		}
	
	
	@GetMapping("/verifyEmail/{email}")
	public String getVerifyEmailId(@PathVariable("email") String email)
	{
		String msg =usersAuthenticationService.verifyEmail(email);
		return msg;
		}

}
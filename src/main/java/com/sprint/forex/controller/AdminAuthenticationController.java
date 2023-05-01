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

import com.sprint.forex.dto.AdminLoginDto;
import com.sprint.forex.entity.Admin;
import com.sprint.forex.service.AdminAuthenticationService;




@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/authen")
public class AdminAuthenticationController {
	
	@Autowired
	private AdminAuthenticationService adminAuthenticationService;
	
	@PostMapping("/admin/login")
	public ResponseEntity<Admin> adminLogin(@RequestBody AdminLoginDto adminLoginDto) {
		
		Admin admin = adminAuthenticationService.doLogin(adminLoginDto.getAdminUsername(), adminLoginDto.getAdminPassword());
				
		ResponseEntity<Admin> responseEntity = new ResponseEntity<>(admin, HttpStatus.OK);
		
		return responseEntity;
   }
	
	@PostMapping("/sendEmail/{toEmail}")
	public String sendEmail(@PathVariable("toEmail") String toEmail) {
		return adminAuthenticationService.sendEmail(toEmail);
		}
	
	
	@DeleteMapping("/verify/{email}/{otp}")
	public String Verifyotp(@PathVariable("email")String adminEmail,@PathVariable("otp") String otp)
	{
		return adminAuthenticationService.verifyOtp(adminEmail, otp);
		}
	
	
	@GetMapping("/verifyEmail/{email}")
	public String getVerifyEmailId(@PathVariable("email") String adminEmail)
	{
		String msg =adminAuthenticationService.verifyEmail(adminEmail);
		return msg;
		}


}

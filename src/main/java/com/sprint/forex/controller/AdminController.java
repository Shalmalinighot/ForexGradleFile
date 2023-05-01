package com.sprint.forex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.AdminDto;
import com.sprint.forex.dto.ExchangeRateDto;
import com.sprint.forex.entity.ExchangeRate;
import com.sprint.forex.exception.InvalidInputException;
import com.sprint.forex.repository.AdminRepository;
import com.sprint.forex.service.AdminService;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	//admin save
	@PostMapping("/admin/save")
	public ResponseEntity<AdminDto> addAdmin(@Valid @RequestBody AdminDto admin) {
		AdminDto newAdmin = adminService.saveAdmin(admin);
		ResponseEntity<AdminDto> responseEntity = new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/admin/exchangeRate/save")
	public ResponseEntity<ExchangeRateDto> addExchangerate(@Valid @RequestBody ExchangeRateDto exchangeRateDto) {
		ExchangeRateDto newExchangeRateDto = adminService.saveExchangeRate(exchangeRateDto);
		ResponseEntity<ExchangeRateDto> responseEntity = new ResponseEntity<>(newExchangeRateDto, HttpStatus.CREATED);
		return responseEntity;
	}
  @PutMapping("admin/exchangeRate/update")
  public ResponseEntity<ExchangeRate> modifyRate(@RequestBody ExchangeRate exchangeRate) {
		ExchangeRate updatedexchangeRate = adminService.updateExchangeRate(exchangeRate);
		ResponseEntity<ExchangeRate> responseEntity = new ResponseEntity<>(updatedexchangeRate, HttpStatus.OK);
		return responseEntity;

	}
  
	@PutMapping("admin/resetpassword")
	public String resetPassword(@RequestParam String adminEmail,@RequestParam String adminPassword ,@Valid @RequestParam String newPassword) throws InvalidInputException {
		return adminService.resetPassword(adminEmail,adminPassword,newPassword);
  }
	@PutMapping("admin/forgotpassword/resetpassword")
	public String forgotPassword(@RequestParam String adminEmail,@RequestParam String newPassword ,@RequestParam String confirmPassword) throws InvalidInputException {
		return adminService.resetForgotPassword(adminEmail,newPassword,confirmPassword);
    }
      
}

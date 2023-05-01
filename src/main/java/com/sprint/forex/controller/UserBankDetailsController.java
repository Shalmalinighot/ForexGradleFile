package com.sprint.forex.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.UserBankDetailsDto;

import com.sprint.forex.service.IUserBankDetailsService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController

public class UserBankDetailsController {
	
	@Autowired
	private IUserBankDetailsService iUserBankDetails;
	
	
	@PostMapping("/UserBankDetails/save")
	public ResponseEntity<UserBankDetailsDto> addBankDetails( @Valid @RequestBody UserBankDetailsDto userBankDetails )
	{
		 UserBankDetailsDto newUserBankDetails = iUserBankDetails.saveBankDetails(userBankDetails);
		ResponseEntity<UserBankDetailsDto> responseEntity = new ResponseEntity<>(newUserBankDetails, HttpStatus.CREATED);
		return responseEntity;
	}
}	
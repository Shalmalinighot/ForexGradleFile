package com.sprint.forex.service;

import java.util.List;

import com.sprint.forex.dto.UserBankDetailsDto;
import com.sprint.forex.entity.UserBankDetails;

public interface IUserBankDetailsService
{
	
	
	public UserBankDetailsDto saveBankDetails(UserBankDetailsDto bankDto) ;
	
	
	public List<UserBankDetails> getAllBankDetails();
	
}
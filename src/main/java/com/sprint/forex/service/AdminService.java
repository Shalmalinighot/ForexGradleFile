package com.sprint.forex.service;

import com.sprint.forex.dto.AdminDto;
import com.sprint.forex.dto.ExchangeRateDto;
import com.sprint.forex.entity.ExchangeRate;
import com.sprint.forex.exception.InvalidInputException;

public interface AdminService {
	AdminDto saveAdmin(AdminDto adminDto);
	public ExchangeRateDto saveExchangeRate(ExchangeRateDto exchangeRateDto);
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);

	
	String resetPassword(String adminEmail, String adminPassword, String newPassword) throws InvalidInputException;
	
	String resetForgotPassword(String adminEmail, String newPassword, String confirmPassword) throws InvalidInputException;

}

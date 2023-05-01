package com.sprint.forex.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.sprint.forex.dto.UserBankDetailsDto;
import com.sprint.forex.entity.UserBankDetails;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.UserBankDetailsNotFoundException;
import com.sprint.forex.exception.UsersNotFoundException;
import com.sprint.forex.repository.IUserBankDetailsRepository;
import com.sprint.forex.repository.UsersRepository;

@Service
public class IUserBankDetailsServiceImpl implements IUserBankDetailsService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private IUserBankDetailsRepository iUserBankDetailsRepository;

	
	@Autowired
	 private MessageSource messageSource;
	

	@Override
	public List<UserBankDetails> getAllBankDetails() {

		List<UserBankDetails> userBankDetailsList = iUserBankDetailsRepository.findAll();

		if (userBankDetailsList.isEmpty()) {
			throw new UserBankDetailsNotFoundException(messageSource.getMessage("bankDetails.not.found ",null,Locale.US));

		}
		return userBankDetailsList;
	}

	@Override
	public UserBankDetailsDto saveBankDetails(UserBankDetailsDto bankDto) {
		Optional<Users> optionalUsers = usersRepository.findById(bankDto.getUserId());
		
		if (optionalUsers.isEmpty()) {
			throw new UsersNotFoundException(messageSource.getMessage("users.not.found",null,Locale.US)+" "+ bankDto.getUserId());
		}
		Users user = optionalUsers.get();
		
		UserBankDetails obj = new UserBankDetails();

		obj.setAccountHolderName(bankDto.getAccountHolderName());
		obj.setBankName(bankDto.getBankName());

		obj.setContactNumber(bankDto.getContactnumber());

		obj.setIfscCode(bankDto.getIfscCode());
		obj.setAccountNumber(bankDto.getAccountNumber());
		obj.setUser(user);
		UserBankDetails newBankDetails = iUserBankDetailsRepository.save(obj);

		UserBankDetailsDto newDto = new UserBankDetailsDto();

		newDto.setUserBankId(newBankDetails.getId());

		newDto.setAccountHolderName(newBankDetails.getAccountHolderName());

		newDto.setAccountNumber(newBankDetails.getAccountNumber());

		newDto.setBankName(newBankDetails.getBankName());

		newDto.setIfscCode(newBankDetails.getIfscCode());

		newDto.setContactnumber(newBankDetails.getContactNumber());

		newDto.setUserId(newBankDetails.getUser().getUsersId());

		return newDto;
		
	}

}
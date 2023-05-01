package com.sprint.forex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.forex.dto.UserBankDetailsDto;
import com.sprint.forex.entity.UserBankDetails;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.TransactionNotFoundException;
import com.sprint.forex.exception.UserBankDetailsNotFoundException;
import com.sprint.forex.exception.UsersNotFoundException;
import com.sprint.forex.repository.IUserBankDetailsRepository;
import com.sprint.forex.repository.UsersRepository;

@SpringBootTest
public class UserBankDetailsTest
{
 
	@InjectMocks
	public IUserBankDetailsServiceImpl userBankDetails;
	
	@Mock
	private UsersRepository usersRepository;
	@Mock
	private IUserBankDetailsRepository iUserBankDetailsRepository;
	
	
	@Test
	public  void TestGetSaveuserBankDetailsException()
	{
		
		
		when(iUserBankDetailsRepository.findAll()).thenThrow(UserBankDetailsNotFoundException.class);
		assertThrows(UserBankDetailsNotFoundException.class,()->userBankDetails.getAllBankDetails());
		
	}
	



	    @Test
	    public void testSaveBankDetails() {
	        // add user details
	        int userId = 1;
	        Users user = new Users();
	        user.setUsersId(userId);
	        UserBankDetailsDto bankDto = new UserBankDetailsDto();
	        bankDto.setUserId(userId);
	        bankDto.setAccountHolderName("Krutika Mhatre");
	        bankDto.setBankName("Bank of India");
	        bankDto.setAccountNumber((long) 1234567890);
	        bankDto.setIfscCode("BOFAUS3N");
	        bankDto.setContactnumber("1234567890");
	        Mockito.when(usersRepository.findById(userId)).thenReturn(Optional.of(user));
	        UserBankDetails savedBankDetails = new UserBankDetails();
	        savedBankDetails.setId(1);
	        savedBankDetails.setAccountHolderName("Krutika Mhatre");
	        savedBankDetails.setBankName("Bank of India");
	        savedBankDetails.setAccountNumber(1234567890);
	        savedBankDetails.setIfscCode("BOFAUS3N");
	        savedBankDetails.setContactNumber("1234567890");
	        savedBankDetails.setUser(user);
	        Mockito.when(iUserBankDetailsRepository.save(Mockito.any(UserBankDetails.class))).thenReturn(savedBankDetails);

	        // action
	        UserBankDetailsDto savedBankDto =userBankDetails.saveBankDetails(bankDto);

	        // assert Methods
	        assertNotNull(savedBankDto);
	        assertNotNull(savedBankDto.getUserBankId());
	        assertNotNull(savedBankDto.getAccountHolderName());
	        assertNotNull(savedBankDto.getBankName());
	        assertNotNull(savedBankDto.getAccountNumber());
	        assertNotNull(savedBankDto.getIfscCode());
	        assertNotNull(savedBankDto.getContactnumber());
	        assertTrue(savedBankDto.getUserBankId() > 0);
	        assertEquals(1, savedBankDto.getUserBankId());
	        assertEquals("Krutika Mhatre", savedBankDto.getAccountHolderName());
	        assertEquals("Bank of India", savedBankDto.getBankName());
	        assertEquals(1234567890, savedBankDto.getAccountNumber());
	        assertEquals("BOFAUS3N", savedBankDto.getIfscCode());
	        assertEquals("1234567890", savedBankDto.getContactnumber());
	        assertEquals(1, savedBankDto.getUserId()  );
	        
	        
	    }

	

	
	
	
	
	
	
	
	
}

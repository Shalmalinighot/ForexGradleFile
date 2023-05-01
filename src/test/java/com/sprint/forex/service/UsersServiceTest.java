package com.sprint.forex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.forex.dto.UsersDto;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.UsersNotFoundException;

import com.sprint.forex.repository.UsersRepository;

@SpringBootTest
public class UsersServiceTest {
	
	@InjectMocks
	private UsersServiceImpl usersService = new UsersServiceImpl();
	
	@Mock
	private UsersRepository usersRepository;
	
	@Test
	public void testSaveUsers() {
	UsersDto usersDto = new UsersDto();
	usersDto.setName("Shivani");
	usersDto.setLocation("Pune");
	usersDto.setGender("Female");
	usersDto.setEmail("Shivani@gmail.com");
	usersDto.setPassword("Shivani@123");
	usersDto.setMobileNo("7020634515");
	
	Users users = new Users();
    users.setUsersId(1);
	users.setName(usersDto.getName());
	users.setLocation(usersDto.getLocation());
	users.setGender(usersDto.getGender());
	users.setEmail(usersDto.getEmail());
	users.setPassword(usersDto.getPassword());
	users.setMobileNo(usersDto.getMobileNo());
	
	when(usersRepository.save(any(Users.class))).thenReturn(users);
	
	UsersDto savedUsers = usersService.saveUsers(usersDto);
	
	assertEquals(users.getName(), savedUsers.getName());
	assertEquals(users.getLocation(), savedUsers.getLocation());
	assertEquals(users.getGender(), savedUsers.getGender());
	assertEquals(users.getEmail(), savedUsers.getEmail());
	assertEquals(users.getPassword(), savedUsers.getPassword());
	assertEquals(users.getMobileNo(), savedUsers.getMobileNo());
	}
	
	@Test
	public void testUsersById() {
		Users users = new Users();
		
		users.setUsersId(1);
		users.setName("Shivani");
		users.setLocation("Pune");
		users.setGender("Female");
		users.setEmail("Shivani@gmail.com");
		users.setPassword("Shivani@123");
		users.setMobileNo("7020634515");

		Optional<Users> optionalUsers = Optional.of(users);
		when(usersRepository.findById(1)).thenReturn(optionalUsers);

		Users usersObj = usersService.getUsersById(1);

		assertEquals("Shivani", usersObj.getName());

		assertEquals("7020634515", usersObj.getMobileNo());
	}
	
	@Test
	public void testGetUsersByIdException() {

		when(usersRepository.findById(1)).thenThrow(UsersNotFoundException.class);

		assertThrows(UsersNotFoundException.class, () -> usersService.getUsersById(1));
	}

	
	@Test
	void testGetAllUsers() {

		List<Users> users = new ArrayList<>();

		Users users1 = new Users();
		users1.setUsersId(1);
		users1.setName("Shivani");
		users1.setLocation("Pune");
		users1.setGender("Female");
		users1.setEmail("Shivani@gmail.com");
		users1.setPassword("Shivani@123");
		users1.setMobileNo("7020634515");

		Users users2 = new Users();
		users2.setUsersId(2);
		users2.setName("Krutika");
		users2.setLocation("mumbai");
		users2.setGender("Female");
		users2.setEmail("Krutika@gmail.com");
		users2.setPassword("Krutika@123");
		users2.setMobileNo("9876543211");
		
		
		Users users3 = new Users();
		users3.setUsersId(3);
		users3.setName("Misba");
		users3.setLocation("Banglore");
		users3.setGender("Female");
		users3.setEmail("Misba@gmail.com");
		users3.setPassword("Misba@123");
		users3.setMobileNo("9876543212");

		users.add(users3);
		users.add(users2);
		users.add(users1);

		when(usersRepository.findAll()).thenReturn(users);

		List<Users> usersList = usersService.getAllUsers();

		assertEquals(3, usersList.size());
	}
	@Test
	public void testDeleteUsers() {

		Users users = new Users();
		users.setUsersId(1);
		users.setName("Shivani");
		users.setLocation("Pune");
		users.setGender("Female");
		users.setEmail("Shivani@gmail.com");
		users.setPassword("Shivani@123");
		users.setMobileNo("7020634515");
		Optional<Users> optionalUsers = Optional.of(users);

		when(usersRepository.findById(1)).thenReturn(optionalUsers);

		doNothing().when(usersRepository).deleteById(1);

		usersService.deleteUsers(1);

		verify(usersRepository, times(1)).findById(1);
		verify(usersRepository, times(1)).deleteById(1);
	}

}

package com.sprint.forex.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.UsersDto;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.InvalidInputException;

import com.sprint.forex.repository.UsersRepository;
import com.sprint.forex.service.UsersService;
import com.sprint.forex.service.UsersServiceImpl;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	@PutMapping("/forgotpassword/resetpassword")
	public String forgotPassword(@RequestParam String email,@RequestParam String newPassword ,@RequestParam String confirmPassword) throws InvalidInputException {
		return usersService.resetForgotPassword(email,newPassword,confirmPassword);
    }
	
	
	@PutMapping("/resetpassword")
	public String resetPassword(@RequestParam String email,@RequestParam String password ,@Valid @RequestParam String newPassword) throws InvalidInputException {
		return usersService.resetPassword(email,password,newPassword);
    }
	
	
	@PostMapping("/users/save")
	public ResponseEntity<UsersDto> addUsers(@RequestBody UsersDto usersDto) {
		UsersDto newUsers = usersService.saveUsers(usersDto);
		ResponseEntity<UsersDto> responseEntity = new ResponseEntity<>(newUsers, HttpStatus.CREATED);
		return responseEntity;
		}
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<String> removeUsers(@PathVariable("id") int usersId) {
		usersService.deleteUsers(usersId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("users Deleted Sucessfully", HttpStatus.OK);
		return responseEntity;
	}
	

	
	@GetMapping("/users/all")
	public List<Users> fetchAllUsers() {
		List<Users> list = usersService.getAllUsers();
		return list;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> fetchUsersDetails(@PathVariable("id") int usersId) {
		Users users = usersService.getUsersById(usersId);
		ResponseEntity<Users> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
		return responseEntity;
	}
	

}
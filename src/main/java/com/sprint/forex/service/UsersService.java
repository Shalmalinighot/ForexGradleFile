package com.sprint.forex.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sprint.forex.dto.UsersDto;
import com.sprint.forex.entity.Users;

import com.sprint.forex.exception.InvalidInputException;

@Service
public interface UsersService {

	public void deleteUsers(int usersId);

	public List<Users> getAllUsers();

	public Users getUsersById(int usersId);

	UsersDto saveUsers(UsersDto usersDto);

	String resetPassword(String email, String password, String newPassword) throws InvalidInputException;

	String resetForgotPassword(String email, String newPassword, String confirmPassword) throws InvalidInputException;

}
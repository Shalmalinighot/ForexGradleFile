package com.sprint.forex.service;

import java.util.Locale;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sprint.forex.entity.Users;
import com.sprint.forex.entity.Verification;
import com.sprint.forex.exception.UsersAuthenticationFailureException;
import com.sprint.forex.exception.UsersEmailNotExistingException;
import com.sprint.forex.repository.UsersRepository;
import com.sprint.forex.repository.VerificationRepository;

@Service
public class UsersAuthenticationServiceImpl implements UsersAuthenticationService {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private VerificationRepository verificationRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Users login(String email, String password) {
		Optional<Users> optionalUsers = usersRepository.findByEmail(email);
		if (optionalUsers.isEmpty()) {
			throw new UsersEmailNotExistingException(messageSource.getMessage("usersEmail.not.found",null,Locale.US));
		}
		Users users = optionalUsers.get();
		if (!password.equals(users.getPassword())) {
			throw new UsersAuthenticationFailureException(messageSource.getMessage("usersAuthentication.fail",null,Locale.US));
		}
		return users;
	}

	@Override
	public String sendEmail(String toEmail) {

		Optional<Users> user = usersRepository.findByEmail(toEmail);
		if (user.isPresent()) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(toEmail);
			message.setSubject("Email Verification for  Application");
			String code = RandomStringUtils.randomNumeric(4);
			message.setText(code);
			javaMailSender.send(message);
			Verification verification = new Verification();

			verification.setUserName(toEmail);
			verification.setOtp(code);
			verificationRepository.save(verification);
			return "mail sent successfully";

		} else {
			throw new UsersAuthenticationFailureException("enter Valid Email");
		}

	}

	@Override
	public String verifyOtp(String email, String otp) {

		Optional<Verification> obj = verificationRepository.findByUserName(email);

		if (obj.isPresent()) {
			Verification obj1 = obj.get();
			if (obj1.getOtp().equals(otp)) {
				verificationRepository.delete(obj1);
				return "otp matched";
			} else {
				throw new UsersEmailNotExistingException("Otp did not matched");
			}

		} else {
			throw new UsersEmailNotExistingException("Enter Valid Email ID");
		}

	}

	@Override
	public String verifyEmail(String email) {
		Optional<Users> user = usersRepository.findByEmail(email);
		if (user.isEmpty()) {
			return "User Not Registered with this Email Id";
		} else {
			return null;
		}
	}

}

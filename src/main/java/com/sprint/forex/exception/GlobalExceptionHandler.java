package com.sprint.forex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<String> handleUsersNotFoundException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<String> handleTransactionNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(UserBankDetailsNotFoundException.class)
	public ResponseEntity<String> UserBankDetailsNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(AdminEmailNotExisting.class)
	public ResponseEntity<String> AdminEmailNotExistingFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<String> InvalidAccountException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(ExchangeRateNotFoundException.class)
	public ResponseEntity<String> handleExchangeRateNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;

	}

	
	@ExceptionHandler(UsersAuthenticationFailureException.class)
	public ResponseEntity<String> handleUsersAuthenticationFailureException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
	@ExceptionHandler(UsersEmailNotExistingException.class)
	 public ResponseEntity<String> UsersEmailNotExistingException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
 }
	
	
	@ExceptionHandler(InvalidInputException.class)
	 public ResponseEntity<String> UsersInvalidInputException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
}
	
}
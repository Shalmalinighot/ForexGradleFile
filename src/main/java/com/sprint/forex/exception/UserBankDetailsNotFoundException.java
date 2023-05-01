package com.sprint.forex.exception;

public class UserBankDetailsNotFoundException extends RuntimeException {
	
	public UserBankDetailsNotFoundException (String msg)
	{
		super(msg);
	}
}

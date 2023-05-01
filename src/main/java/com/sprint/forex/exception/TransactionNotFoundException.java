package com.sprint.forex.exception;

public class TransactionNotFoundException extends RuntimeException{
    
	public TransactionNotFoundException(String msg) {
	  	  super(msg);
   }
}

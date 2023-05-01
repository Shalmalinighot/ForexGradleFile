package com.sprint.forex.exception;

public class InvalidAccountException extends RuntimeException{
     public  InvalidAccountException(String msg) {
    	 super(msg);
     }
}

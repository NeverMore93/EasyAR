package com.easyar.exception;

public class UserIDNoFindException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 142937844739143415L;
	
	public  UserIDNoFindException(String msg,Throwable t){
		super(msg,t);
	}

}

package com.apsidiscount.exceptions;

public class LoginAndPasswordException extends ApsiDiscountException {
	
	public LoginAndPasswordException() {
		
		super("Login ou mot de passe inconnu");
	}
}

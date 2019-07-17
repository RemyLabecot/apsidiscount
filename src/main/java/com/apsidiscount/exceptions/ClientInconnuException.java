package com.apsidiscount.exceptions;

public class ClientInconnuException extends ApsiDiscountException {

	public ClientInconnuException(long idClient) {
		super("Le client avec l'ID " + idClient + " n'existe pas !");
	}

}

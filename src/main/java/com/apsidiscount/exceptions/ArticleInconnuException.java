package com.apsidiscount.exceptions;

public class ArticleInconnuException extends ApsiDiscountException {

	public ArticleInconnuException(long idArticle) {
		super("L'article avec l'ID " + idArticle + " n'existe pas !");
	}

}

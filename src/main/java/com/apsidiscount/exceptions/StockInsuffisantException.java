package com.apsidiscount.exceptions;

import com.apsidiscount.entity.Article;

public class StockInsuffisantException extends ApsiDiscountException {

	public StockInsuffisantException(Article article) {
		super("L'article " + article.getDesignation() + " n'est plus en stock !");
	}

}

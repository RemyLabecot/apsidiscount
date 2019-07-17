package com.apsidiscount.service;


import com.apsidiscount.exceptions.ArticleInconnuException;
import com.apsidiscount.exceptions.ClientInconnuException;
import com.apsidiscount.exceptions.StockInsuffisantException;

public interface ClientService {

    void ajouterArticlesDansPanier(long idClient, long ... idArticles) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException;

}

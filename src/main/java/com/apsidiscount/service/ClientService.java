package com.apsidiscount.service;


import com.apsidiscount.entity.Client;
import com.apsidiscount.exceptions.ArticleInconnuException;
import com.apsidiscount.exceptions.ClientInconnuException;
import com.apsidiscount.exceptions.LoginAndPasswordException;
import com.apsidiscount.exceptions.StockInsuffisantException;

public interface ClientService {

    void ajouterArticlesDansPanier(long idClient, long ... idArticles) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException;

    Client getClientByNameAndPassword(String email, String password) throws LoginAndPasswordException;
}

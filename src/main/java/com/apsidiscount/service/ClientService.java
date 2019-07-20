package com.apsidiscount.service;


import java.util.List;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Client;
import com.apsidiscount.exceptions.ArticleInconnuException;
import com.apsidiscount.exceptions.ClientInconnuException;
import com.apsidiscount.exceptions.LoginAndPasswordException;
import com.apsidiscount.exceptions.StockInsuffisantException;

public interface ClientService {

    Article ajouterArticleDansPanier(long idClient, long idArticle) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException;

    Client getClientByNameAndPassword(String email, String password) throws LoginAndPasswordException;
    
    List<Article> getArticlesByIdClient(long id);
    
    void deleteArticleFromPanier(long idClient, long idArticle) throws ClientInconnuException, ArticleInconnuException;
}

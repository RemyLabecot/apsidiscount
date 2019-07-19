package com.apsidiscount.service;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.dao.ClientDAO;
import com.apsidiscount.dao.PanierDAO;
import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Client;
import com.apsidiscount.entity.Panier;
import com.apsidiscount.exceptions.ApsiDiscountException;
import com.apsidiscount.exceptions.ArticleInconnuException;
import com.apsidiscount.exceptions.ClientInconnuException;
import com.apsidiscount.exceptions.LoginAndPasswordException;
import com.apsidiscount.exceptions.StockInsuffisantException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;
    private ArticleDAO articleDAO;
    private PanierDAO panierDAO;

    public ClientServiceImpl(ClientDAO clientDAO, ArticleDAO articleDAO, PanierDAO panierDAO) {
        this.clientDAO = clientDAO;
        this.articleDAO = articleDAO;
        this.panierDAO = panierDAO;
    }

    @Override
    @Transactional(rollbackOn = ApsiDiscountException.class)
    public void ajouterArticlesDansPanier(long idClient, long... idArticles) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException {

        Client client = clientDAO.getById(idClient);
        if (client == null) {
            throw new ClientInconnuException(idClient);
        }

        if (!client.hasPanier()) {
            Panier panier = new Panier();
            panierDAO.create(panier);
            client.setPanier(panier);
        }

        for (long idArticle : idArticles) {
            Article article = articleDAO.getById(idArticle);
            if (article == null) {
                throw new ArticleInconnuException(idArticle);
            }
            if(! client.getPanier().contient(article)) {
                client.getPanier().addArticle(article);
            }
        }
    }
    
    public Client getClientByNameAndPassword(String email, String password) throws LoginAndPasswordException{
    	return clientDAO.getClientByNameAndPassword(email, password);
    }
}

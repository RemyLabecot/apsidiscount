package com.apsidiscount.dao;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;

	public ArticleDAOImpl() {
		super();
	}

	public ArticleDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Article getById(long id) {

		return this.em.find(Article.class, id);
	}

	@Override
	public List<Article> getByCategorie(String nomCategorie) {
		return this.em.createQuery("select a from Article a where a.categorie.nom = :nomCategorie", Article.class)
				      .setParameter("nomCategorie", nomCategorie)
				      .getResultList();
	}

	@Override
	public List<Article> getByCategorie(Categorie categorie) {
		return this.em.createQuery("select a from Article a where a.categorie = :categorie", Article.class)
				      .setParameter("categorie", categorie)
			          .getResultList();
	}

	@Override
	public List<Article> getArticles() {
		return this.em.createQuery("select a from Article a", Article.class)
				.getResultList();
	}
	
	@Override
	public Article create(Article a) {
		this.em.persist(a);
		return a;
	}
}

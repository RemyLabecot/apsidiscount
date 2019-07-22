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
	public List<Article> getByCategorie(long idCategorie) {
		return this.em.createQuery("select a from Article a where a.categorie.id = :idCategorie", Article.class)
				      .setParameter("idCategorie", idCategorie)
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
	
	
	@Override
	public void delete(long id) {
		this.em.createQuery("delete from Article a where a.id = :id")
			.setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public List<Article> getArticlesWithSort() {
		return this.em.createQuery("select new Article(a.id, a.designation, a.prix, a.stock, a.image) from Article a", Article.class)
				.getResultList();
	}
	@Override
	
	public List<Article> getArticlesWithSortRCP() {
		return this.em.createQuery("select new Article(a.id, a.designation, a.prix, a.stock, a.miseEnLigne) from Article a", Article.class)
				.getResultList();
	}
}

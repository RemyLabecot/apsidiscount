package com.apsidiscount.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apsidiscount.entity.Categorie;

@Repository
public class CategorieDAOImpl implements CategorieDAO{

	@PersistenceContext
	private EntityManager em;

	public CategorieDAOImpl() {
		super();
	}

	public CategorieDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Categorie> getCategories() {
		return this.em.createQuery("select c from Categorie c", Categorie.class)
				.getResultList();
	}


}

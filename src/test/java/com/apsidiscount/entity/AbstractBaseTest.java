package com.apsidiscount.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractBaseTest {
	
	private EntityManagerFactory emf;
	protected EntityManager em;

	@Before
	public void createEntityManager() {
		emf = Persistence.createEntityManagerFactory("apsidiscount");
		em = emf.createEntityManager();
	}

	@After
	public void closeEntityManager() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}

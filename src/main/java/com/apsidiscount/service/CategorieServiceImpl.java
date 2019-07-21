package com.apsidiscount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidiscount.dao.CategorieDAO;
import com.apsidiscount.entity.Categorie;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieDAO categorieDao;

	@Override
	public List<Categorie> getCategories() {
		return this.categorieDao.getCategories();
	}
}

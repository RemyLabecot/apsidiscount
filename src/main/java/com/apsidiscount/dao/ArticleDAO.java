package com.apsidiscount.dao;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;


import java.util.List;


public interface ArticleDAO {

	Article getById(long id);

	List<Article> getByCategorie(String nomCategorie);

	List<Article> getByCategorie(Categorie categorie);

	List<Article> getArticles();

	Article create(Article a);
	
	void delete(long id);
	
	List<Article> getArticlesWithSort();

	List<Article> getArticlesWithSortRCP();
}

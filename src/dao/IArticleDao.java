package dao;

import java.util.List;

import domaine.classes.Article;

public interface IArticleDao {

	public Article save(Article art);
	public List<Article> Search (String intitule);
	public Article getArticle(int id);
	public Article update(Article art);
	public int delete (int id);
}

package web;

import java.util.ArrayList;
import java.util.List;

import domaine.classes.Article;

public class ArticleModel {
	
	private String intituleSearched;
	private List<Article> listeArticle = new ArrayList<Article>();
	public String getIntituleSearched() {
		return intituleSearched;
	}
	public void setIntituleSearched(String intituleSearched) {
		this.intituleSearched = intituleSearched;
	}
	public List<Article> getListeArticle() {
		return listeArticle;
	}
	public void setListeArticle(ArrayList<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	

}

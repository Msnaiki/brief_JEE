package web;

import java.io.IOException;
 

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDaoImp;
import dao.IArticleDao;
import domaine.classes.Article;
 

public class ControleurServlet extends HttpServlet{

	private IArticleDao metier;
	
	public void init() throws ServletException {
		 metier = new ArticleDaoImp();

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 String path = request.getServletPath();
	 
	 if(path.equals("/index.php"))
	 {
		
		 request.getRequestDispatcher("article.jsp").forward(request, response);

	 }
	 else if(path.equals("/chercher.php"))
	 {
		 
		 String inputValue = request.getParameter("inputIntitule");
		 ArticleModel model = new ArticleModel();
		 model.setIntituleSearched(inputValue);
		 List<Article> articles = metier.Search("%"+inputValue+"%");
		 model.setListeArticle((ArrayList<Article>) articles);
		 request.setAttribute("model", model);
		 request.getRequestDispatcher("article.jsp").forward(request, response);

	 }
	 else if(path.equals("/saisie.php"))
	 {
		 request.setAttribute("article", new Article());
		 request.getRequestDispatcher("insertArticle.jsp").forward(request, response);
	 }
	 else if(path.equals("/saveArticle.php") && request.getMethod().equals("POST"))
	 {
		 String intitule = request.getParameter("intitule");
		 double prix = Double.parseDouble(request.getParameter("prix"));
		 int qStock = Integer.parseInt(request.getParameter("qstock"));
		 
		 Article art = metier.save(new Article(intitule, prix, qStock) );
		 request.setAttribute("article", art);
		 request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		 
		 
	 }
	 else if(path.equals("/supprimer.php"))
	 {
		 int id = Integer.parseInt(request.getParameter("id"));
		 metier.delete(id);
		// request.getRequestDispatcher("article.jsp").forward(request, response);
		 response.sendRedirect("chercher.php?inputIntitule=");
		 
	 }
	 else if(path.equals("/modifier.php"))
	 {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Article art = metier.getArticle(id);
		 request.setAttribute("article", art);
		 request.getRequestDispatcher("updateArticle.jsp").forward(request, response);

	 }
	 else if(path.equals("/updateArticle.php") && request.getMethod().equals("POST"))
	 {
		 int id = Integer.parseInt(request.getParameter("id"));
		 String intitule = request.getParameter("intitule");
		 double prix = Double.parseDouble(request.getParameter("prix"));
		 int qStock = Integer.parseInt(request.getParameter("qstock"));
		 
		 Article art = new Article(intitule, prix, qStock) ;
		 art.setId(id);
		 
		 metier.update(art);
		 request.setAttribute("article", art);
		 request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		 
		 
	 }
	 else
	 {
		 response.sendError(response.SC_NOT_FOUND);
	 }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}

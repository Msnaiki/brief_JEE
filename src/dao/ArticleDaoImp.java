package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.access.utileConnection;
import domaine.classes.Article;

public class ArticleDaoImp implements IArticleDao{

	@Override
	public Article save(Article art) {
		
		Connection connect = utileConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("INSERT INTO article (intitule,prix,quantiteStock) VALUES (?,?,?)");
			ps.setString(1,art.getIntitule());
			ps.setDouble(2, art.getPrix());
			ps.setInt(3, art.getQteStock());
			ps.executeUpdate();
			PreparedStatement psId = connect.prepareStatement("SELECT MAX(id) as maxID FROM article");
			ResultSet rs = psId.executeQuery();
			if(rs.next())
			{
				art.setId(rs.getInt("maxID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return art;
	}

	
	

	@Override
	public Article getArticle(int id) {

		 Article article = null ;
		Connection connect = utileConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM article WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setIntitule(rs.getString("intitule"));
				article.setPrix(rs.getDouble("prix"));
				article.setQteStock(rs.getInt("quantiteStock"));
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public Article update(Article art) {
		Connection connect = utileConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("UPDATE article SET intitule=? ,prix=? ,quantiteStock=? WHERE id =?");
			ps.setString(1,art.getIntitule());
			ps.setDouble(2, art.getPrix());
			ps.setInt(3, art.getQteStock());
			ps.setInt(4, art.getId());
			ps.executeUpdate();
		 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return art;

	}

	@Override
	public int delete(int id) {
		Connection connect = utileConnection.getConnection();
		int ret =0;
		try {
			
			PreparedStatement ps = connect.prepareStatement("DELETE FROM article WHERE id = ?");
			ps.setInt(1,id);
	 
			ret = ps.executeUpdate();
 
			ps.close();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public List<Article> Search(String intitule) {
		
		List<Article> listArticle = new ArrayList<Article>();
		Connection connect = utileConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM article WHERE intitule LIKE ? ");
			ps.setString(1, intitule);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Article a = new Article();
				a.setId(rs.getInt("id"));
				a.setIntitule(rs.getString("intitule"));
				a.setPrix(rs.getDouble("prix"));
				a.setQteStock(rs.getInt("quantiteStock"));
				listArticle.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listArticle;
	}

}

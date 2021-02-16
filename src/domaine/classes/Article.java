package domaine.classes;

public class Article {
	
	
	private int id ;
	private String intitule;
	private double prix;
	private int qteStock;
	
	
	
	public Article(String intitule, double prix, int qteStock) {
		super();
		this.intitule = intitule;
		this.prix = prix;
		this.qteStock = qteStock;
	}
	public Article(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	public String toString()
	{
		return "ID : "+String.valueOf(getId()) + " Intitule : " +getIntitule() + " Prix : "+String.valueOf(getPrix())+" Quantité : "+String.valueOf(getQteStock());
	}
	
	

}

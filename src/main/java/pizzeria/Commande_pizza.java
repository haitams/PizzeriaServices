package pizzeria;

public class Commande_pizza
{
	int id;
	String nom_pizza ;
	String token ;
	int quantiter ;
	double prix ;
	public String getNom_pizza() {
		return nom_pizza;
	}
	public void setNom_pizza(String nom_pizza) {
		this.nom_pizza = nom_pizza;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getQuantiter() {
		return quantiter;
	}
	public void setQuantiter(int quantiter) {
		this.quantiter = quantiter;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Commande_pizza(int id, String nom_pizza, String token, int quantiter, double prix) {
		
		this.nom_pizza = nom_pizza;
		this.token = token;
		this.quantiter = quantiter;
		this.prix = prix;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

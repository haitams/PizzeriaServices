package pizzeria;

public class Commande_pizza
{
	String nom_pizza ;
	String token ;
	int quantiter ;
	double prix ;
	public Commande_pizza(String nom_pizza, String token, int quantiter, double prix) {
		
		this.nom_pizza = nom_pizza;
		this.token = token;
		this.quantiter = quantiter;
		this.prix = prix;
	}
	
	
}

package pizzeria;

public class Commande_pizza
{
	int id ;
	String nom_pizza ;
	String token ;
	int quantiter ;
	double prix ;

	public Commande_pizza( int id , String nom_pizza , String token , int quantiter , double prix )
	{
		this.nom_pizza = nom_pizza ;
		this.token = token ;
		this.quantiter = quantiter ;
		this.prix = prix ;
		this.id = id ;
	}
	
	public int get_id()
	{
		return id ;
	}
	
	public void set_id( int id )
	{
		this.id = id ;
	}
	
	public String get_nom_pizza()
	{
		return nom_pizza ;
	}
	
	public void set_nom_pizza( String nom_pizza )
	{
		this.nom_pizza = nom_pizza ;
	}
	
	public String get_token()
	{
		return token ;
	}
	
	public void set_token( String token )
	{
		this.token = token ;
	}
	
	public int get_quantiter()
	{
		return quantiter ;
	}
	
	public void set_quantiter( int quantiter )
	{
		this.quantiter = quantiter ;
	}
	
	public double get_prix()
	{
		return prix ;
	}
	
	public void set_prix( double prix )
	{
		this.prix = prix ;
	}
}

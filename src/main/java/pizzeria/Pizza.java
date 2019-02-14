package pizzeria;

public class Pizza
{
	private String nom_pizza ;
	private String description_pizza ;
	private double prix_pizza ;
	
	public Pizza( String nom , String description , double prix )
	{
		this.nom_pizza = nom ;
		this.description_pizza = description ;
		this.prix_pizza = prix ;
	}

	public String get_nom_pizza()
	{
		return nom_pizza ;
	}

	public void set_nom_pizza( String nom_pizza )
	{
		this.nom_pizza = nom_pizza ;
	}
	
	public String get_description_pizza()
	{
		return this.description_pizza ;
	}
	
	public void set_description_pizza( String description )
	{
		this.description_pizza = description ;
	}

	public double get_prix_pizza()
	{
		return prix_pizza ;
	}

	public void set_prix_pizza( double prix_pizza )
	{
		this.prix_pizza = prix_pizza ;
	}
	
}

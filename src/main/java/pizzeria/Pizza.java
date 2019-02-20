package pizzeria;
/**
 * class to implement to identification of a Pizza
 * @author LUCK Bastien - OURKIA Yassin
 *
 */
public class Pizza
{
	/*--------------------------------------------------
	 * 
	 * 		Attributes
	 * 
	 --------------------------------------------------*/
	private String nom_pizza ;
	private String description_pizza ;
	private double prix_pizza ;
	private int id_pizza;
	/**
	 * Constructor with parameters
	 * @param id id of the pizza
	 * @param nom name of the pizza
	 * @param description description of the pizza
	 * @param prix the price of each unity of the pizza
	 */
	public Pizza( int id , String nom , String description , double prix )
	{
		this.id_pizza = id;
		this.nom_pizza = nom ;
		this.description_pizza = description ;
		this.prix_pizza = prix ;
	}
	
	/*--------------------------------------------------
	 * 
	 * 		Getters and setters
	 * 
	 --------------------------------------------------*/
	public int getId_pizza() {
		return id_pizza;
	}


	public void setId_pizza(int id_pizza) {
		this.id_pizza = id_pizza;
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

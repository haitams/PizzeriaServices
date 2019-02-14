package pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_commandes" , serviceName = "pizzeria_commandes" , portName = "Pizzeria_commandes_port" )
public class Pizzeria_service_commandes_impl implements Pizzeria_service_commandes
{
	private Map<Integer,Commande_pizza> commandes = new HashMap<Integer,Commande_pizza>() ;
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() ;
	
	public Pizzeria_service_commandes_impl()
	{
		pizzas.add( new Pizza( "Savoyarde" , "Pour toutes les faims :)" , 8.25 ) ) ;
	}
	
	@Override
	public String commande_pizza( String nom_pizza , int quantiter )
	{
		return "" ;
	}

	@Override
	public String annuler_commande_pizza( String token )
	{
		return "";
	}

	@Override
	public String ajouter_pizza( String nom_pizza , String description , double prix )
	{
		return "" ;
	}

	@Override
	public String supprimer_pizza( String nom_pizza )
	{
		return "" ;
	}

	@Override
	public ArrayList<Pizza> get_liste_pizza()
	{
		System.out.println( "get_liste_pizza method has been invoked." ) ;
		return this.pizzas ;
	}

	@Override
	public Pizza get_pizza_at( String nom_pizza )
	{
		System.out.println( "get_pizza_at method has been invoked: " + nom_pizza ) ;
		if ( nom_pizza == null || nom_pizza.isEmpty() )
		{
			throw new NullPointerException( "Name is null." ) ;
		}
		else
		{
			for ( Pizza pizza : pizzas )
			{
				if ( nom_pizza.equals( pizza.get_nom_pizza() ) )
					{
						return pizza ;
					}
			}
		}
		return null ;
	}
}

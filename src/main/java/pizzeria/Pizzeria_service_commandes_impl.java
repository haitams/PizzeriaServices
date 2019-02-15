package pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_commandes" , serviceName = "pizzeria_commandes" , portName = "Pizzeria_commandes_port" )
public class Pizzeria_service_commandes_impl implements Pizzeria_service_commandes
{
	private ArrayList<Commande_pizza> commandes = new ArrayList<Commande_pizza>() ;
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() ;
	
	ArrayList<Person> users = Pizzeria_service_gestion_utilisateur_impl.persons;
	public Pizzeria_service_commandes_impl()
	{
		
	}
	
	@Override
	public String commande_pizza(String nom_pizza, int quantiter, String token) {
		
		
		for (Person personne : users)
		{
			if(personne.get_token().equals(token))
			{
				double prix =0;
				for(Pizza p : pizzas)
				{
					if(p.get_nom_pizza().equals(nom_pizza)) 
					{
						prix = p.get_prix_pizza();
						this.commandes.add(new Commande_pizza(this.commandes.size(),nom_pizza,token,quantiter,prix*quantiter));
						return "Prise de commande reussie";
					}
				}
				
			}
		}
		return "Prise de commande echoue";
	}

	@Override
	public String annuler_commande_pizza( int id , String token )
	{
		
			if(this.commandes.get(id).token.equals(token))
			{
				this.commandes.remove(id);
				return "Commande Annulee";
			}
		return "Echoue d'annulation de commande";
	}

	@Override
	public String ajouter_pizza( String nom_pizza , String description , double prix , String token)
	{
		for (Person personne : users)
		{
			if(personne.is_admin() && personne.get_token().equals(token)) 
			{
				if(!nom_pizza.equals("") && !description.equals("") && prix > 2) 
				{
					this.pizzas.add(new Pizza(nom_pizza, description, prix));
					return "Ajout de pizza a bien reussi";
				}
			}					
		}
		return "Ajout de pizza a echoue" ;
	
	}

	@Override
	public String supprimer_pizza( String nom_pizza,String token )
	{
		for (Person personne : users)
		{
			if(personne.is_admin() && personne.get_token().equals(token)) 
			{
				for(Pizza pizza : this.pizzas)
				{
					if(pizza.get_nom_pizza().equals(nom_pizza)) 
					{
						this.pizzas.remove(pizza);
						return "Suppression de pizza a bien reussi";
					}
				}
			}					
		}
		return "Suppression de pizza a echoue" ;
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

	@Override
	public ArrayList<Commande_pizza> get_list_commandes() {
		return this.commandes;
	}




	
}

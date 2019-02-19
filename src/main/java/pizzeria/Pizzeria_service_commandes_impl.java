package pizzeria;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_commandes" , serviceName = "pizzeria_commandes" , portName = "Pizzeria_commandes_port" )
public class Pizzeria_service_commandes_impl implements Pizzeria_service_commandes
{
	public static ArrayList<Commande_pizza> commandes = new ArrayList<Commande_pizza>() ;
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() ;
	private ArrayList<Person> personnes = Pizzeria_service_gestion_utilisateur_impl.personnes ;
	
	public Pizzeria_service_commandes_impl()
	{
		pizzas.add(new Pizza(0,"cannibale", "poulet, viande hache, mergez, moza", 8));
		pizzas.add(new Pizza(1,"savoyarde", "jambon, viande hache, champignon, moza", 9));
	}
	
	@Override
	public String commande_pizza( int id_pizza , int quantiter , String token )
	{
		if(this.personnes.size()> 0) 
		{
			for ( Person check_bdd_personne : this.personnes )
			{
				if (check_bdd_personne.get_token() != null &&  check_bdd_personne.get_token().equals( token )  )
				{
					if ( check_bdd_personne.is_admin() == false )
					{
						double prix = 0 ;
						for( Pizza check_bdd_pizza : this.pizzas )
						{
							if ( check_bdd_pizza.getId_pizza() ==  id_pizza  ) 
							{
								prix = check_bdd_pizza.get_prix_pizza() ;
								Commande_pizza commande =  new Commande_pizza( Pizzeria_service_commandes_impl.commandes.size() , check_bdd_pizza.get_nom_pizza() , token , quantiter , prix * quantiter );
								commande.setStatus("non payee");
								Pizzeria_service_commandes_impl.commandes.add(commande ) ;
								return "Prise de commande reussie" ;
							}
						}
						return "Nom de pizza errone";
					}
					return "Seul les utilisateurs non administrateur peuvent commander une pizza." ;
				}
			}
			return "Token invalide" ;
		}
		else
		{
			return "Aucune utilisateur dans la base de donnée";
		}
	}

	@Override
	public String annuler_commande_pizza( int id , String token )
	{
		if ( id >= 0 && id < Pizzeria_service_commandes_impl.commandes.size() )
		{
			for(Person personne : personnes) {
				if ( personne.get_token().equals( token ) )
				{
					if(Pizzeria_service_commandes_impl.commandes.get( id ).getStatus().equals("non payee"))
					{
						Pizzeria_service_commandes_impl.commandes.remove( id ) ;
						return "La commande numero " + id + " est annulee." ;
					}
					else
					{
						return "cette commande est deja payee";
					}
				}
			}
			return "Token invalid";
			
		}
		return "Id invalide" ;
	}

	@Override
	public ArrayList<Commande_pizza> get_liste_commandes(String token)
	{
		ArrayList<Commande_pizza> mycommands = new ArrayList<>();
		for ( Person check_bdd_personne : this.personnes )
		{
			if ( check_bdd_personne.get_token().equals( token ) )
			{
				for(Commande_pizza cmd : commandes) {
					if(cmd.get_token().equals(token))
						mycommands.add(cmd);
				}
				return mycommands ;
			}
		}
		throw new NullPointerException( "Token invalid." ) ;
	}

	@Override
	public String ajouter_pizza( String nom_pizza , String description , double prix , String token )
	{
		for ( Person check_bdd_personne : this.personnes )
		{
			if ( check_bdd_personne.get_token().equals( token ) )
			{
				if ( check_bdd_personne.is_admin() == true ) 
				{
					for ( Pizza check_bdd_pizza : this.pizzas )
					{
						if ( check_bdd_pizza.get_nom_pizza().equals( nom_pizza ) == true )
						{
							return "Cette pizza est deja disponible a la vente." ;
						}
					}
					if ( nom_pizza.equals( "" ) == false ) 
					{
						if ( description.equals( "" ) == false )
						{
							if ( prix > 2 )
							{
								this.pizzas.add( new Pizza( this.pizzas.size(),nom_pizza , description , prix ) ) ;
								return "La pizza " + nom_pizza + " est maintenant disponible pour la vente." ;
							}
							return "L'entreprise a pour regle de rentabiliter de ne pas vendre une pizza pour moins de 2 euros." ;
						}
						return "Veuillez renseigner une description de la pizza avant de l'ajouter." ;
					}
					return "Il est impossible de rajouter une pizza sans lui donner un nom." ;
				}
				return "Seul les admistrateurs peuvent ajouter une nouvelle pizza sur la carte." ;
			}
		}
		return "Token invalide." ;
	
	}

	@Override
	public String supprimer_pizza( String nom_pizza , String token )
	{
		for ( Person check_bdd_personne : personnes )
		{
			if ( check_bdd_personne.get_token().equals( token ) ) 
			{
				if ( check_bdd_personne.is_admin() == true )
				{
					for ( Pizza check_bdd_pizza : this.pizzas )
					{
						if ( check_bdd_pizza.get_nom_pizza().equals( nom_pizza ) ) 
						{
							this.pizzas.remove( check_bdd_pizza ) ;
							return "La pizza " + nom_pizza + " n'est maintenant plus disponible a la vente." ;
						}
					}
				}
				return "Seul les administrateurs peuvent supprimer une pizza de la carte." ;
			}
		}
		return "Token invalide." ;
	}

	@Override
	public ArrayList<Pizza> get_carte_restaurant()
	{
		return this.pizzas ;
	}

	@Override
	public Pizza get_pizza_at( String nom_pizza )
	{
		if ( nom_pizza == "" )
		{
			throw new NullPointerException( "Name is null." ) ;
		}
		for ( Pizza check_bdd : pizzas )
		{
			if ( nom_pizza.equals( check_bdd.get_nom_pizza() ) )
			{
				return check_bdd ;
			}
		}
		throw new NullPointerException( "Cette pizza n'existe pas." ) ;
	}
}

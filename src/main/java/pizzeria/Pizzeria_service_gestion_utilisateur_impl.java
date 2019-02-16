package pizzeria;

import java.security.SecureRandom;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_gestion_utilisateur" , serviceName = "pizzeria_gestion_utilisateur" , portName = "Pizzeria_gestion_utilisateur_port" )
public class Pizzeria_service_gestion_utilisateur_impl implements Pizzeria_service_gestion_utilisateur
{
	public static ArrayList<Person> personnes = new ArrayList<Person>() ;
	
	public Pizzeria_service_gestion_utilisateur_impl()
	{
		
	}
	
	@Override
	public String inscription( String nom , String mot_de_passe , String mot_de_passe_verification , boolean is_admin )
	{
		for( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
		{
			if ( check_bdd.get_nom().equals( nom ) == true && check_bdd.get_mot_de_passe().equals( mot_de_passe ) == true )
			{
				return "Ce compte existe deja." ;
			}
		}
		if ( mot_de_passe.equals( mot_de_passe_verification ) == true )
		{
			if ( nom.length() > 1 )
			{
				if ( nom.length() <= 10 )
				{
					Person personne = new Person( nom , mot_de_passe , "" , Pizzeria_service_gestion_utilisateur_impl.personnes.size() , is_admin ) ;
					
					try
					{
						Thread.sleep( 5000 ) ;
					} catch (InterruptedException e) {e.printStackTrace();}
					
					Pizzeria_service_gestion_utilisateur_impl.personnes.add( personne ) ;
					return "Inscription reussie." ;
				}
				return "Le nom entrer est trop long (supperieur a 10 caracteres)." ;
			}
			return "Le nom entrer est trop court (inferieur a 2 caracteres)." ;
		}
		return "Les mots de passes sont differents entre eux" ;
	}

	@Override
	public String connexion( String nom , String mot_de_passe )
	{
		for ( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
		{
			if ( check_bdd.get_nom().equals( nom ) == true && check_bdd.get_mot_de_passe().equals( mot_de_passe ) == true )
			{
				byte[] array = new byte[20] ;
			    new SecureRandom().nextBytes( array ) ;
			    String token =  array.toString().substring( 3 , array.toString().length() ) ;
				check_bdd.set_token( token ) ;
				if ( check_bdd.is_admin() == true )
				{
					return "Connexion reussie, votre token a utiliser pour faire des modifications est : " + check_bdd.get_token() ;
				}
				return "Connexion reussie, votre token a utiliser pour faire une commande est : " + check_bdd.get_token() ;
			}
		}
		return "Nom ou mot de passe erroner." ;
	}
	
	@Override
	public String deconnexion( String token )
	{
		for ( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
		{
			if ( check_bdd.get_token().equals( token ) == true )
			{
				check_bdd.set_token( "" ) ;
				return "Deconnexion reussie, a bientot " + check_bdd.get_nom() + " :)." ;
			}
		}
		return "Token invalide." ;
	}

	@Override
	public ArrayList<Person> get_persons( String token )
	{
		for ( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
		{
			if ( check_bdd.get_token().equals( token ) == true )
			{
				if ( check_bdd.is_admin() == true )
				{
					return Pizzeria_service_gestion_utilisateur_impl.personnes ;
				}
				throw new NullPointerException( "Seul les administrateurs peuvent obtenir la liste complete des utilisateurs." ) ;
			}
			
		}
		throw new NullPointerException( "Token invalide." ) ;
	}

	@Override
	public Person get_person_at( int id , String token )
	{
		if ( id >= 0 || id < Pizzeria_service_gestion_utilisateur_impl.personnes.size() )
		{
			for ( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
			{
				if ( check_bdd.is_admin() == true && check_bdd.get_token().equals( token ) )
				{
					return check_bdd ;
				}
			}
			if ( Pizzeria_service_gestion_utilisateur_impl.personnes.get( id ).get_token().equals( token ) )
			{
				return Pizzeria_service_gestion_utilisateur_impl.personnes.get( id ) ;
			}
			throw new NullPointerException( "Les utilisateurs non administrateurs ne sont autoriser qu'a visualiser leur compte." ) ;
		}
		throw new NullPointerException( "Id invalide." ) ;
	}

	@Override
	public String suppression_utilisateur( int id , String token )
	{
		if ( id >= 0 && id < Pizzeria_service_gestion_utilisateur_impl.personnes.size() )
		{
			for ( Person check_bdd : Pizzeria_service_gestion_utilisateur_impl.personnes )
			{
				if ( check_bdd.get_token().equals( token ) == true )
				{
					Person deleted_user = Pizzeria_service_gestion_utilisateur_impl.personnes.remove( id ) ;
					return deleted_user.get_nom() + " ne fait plus parti des clients" ;
				}
			}
			return "Seul un administrateur peut supprimer un utilisateur" ;
		}
		return "Id invalide" ;
	}
}

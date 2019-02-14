package pizzeria;

import java.security.SecureRandom;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_gestion_utilisateur" , serviceName = "pizzeria_gestion_utilisateur" , portName = "Pizzeria_gestion_utilisateur_port" )
public class Pizzeria_service_gestion_utilisateur_impl implements Pizzeria_service_gestion_utilisateur
{
	private ArrayList<Person> persons = new ArrayList<Person>() ;
	
	public Pizzeria_service_gestion_utilisateur_impl()
	{
		
	}
	
	@Override
	public String inscription( String nom , String mot_de_passe , String mot_de_passe_verification , boolean is_admin )
	{
		for( Person check_bdd : this.persons )
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
					Person personne = new Person( nom , mot_de_passe , this.token_generation() , this.persons.size() , is_admin ) ;
					System.out.println( "addPerson method has been invoked:" + personne.toString() ) ;
					
					try
					{
						Thread.sleep( 5000 ) ;
					} catch (InterruptedException e) {e.printStackTrace();}
					
					this.persons.add( personne ) ;
					return "Inscription reussie." ;
				}
				else
				{
					return "Le nom entrer est trop long (> 10 caracteres)." ;
				}
			}
			else
			{
				return "Le nom entrer est trop court (< 2 caracteres)." ;
			}
		}
		else
		{
			return "Les mots de passes sont differents entre eux" ;
		}
	}

	@Override
	public String connexion( String nom , String mot_de_passe )
	{
		for ( Person check_bdd : this.persons )
		{
			if ( check_bdd.get_nom().equals( nom ) == true && check_bdd.get_mot_de_passe().equals( mot_de_passe ) == true )
			{
				check_bdd.set_token( this.token_generation() ) ;
				return "Connexion reussie." ;
			}
		}
		return "Nom ou mot de passe erroner." ;
	}
	
	@Override
	public String deconnexion( String token )
	{
		for ( Person check_bdd : this.persons )
		{
			if ( check_bdd.get_token().equals( token ) == true )
			{
				check_bdd.set_token( "" ) ;
				return "Deconnexion reussie" ;
			}
		}
		return "Token erroner." ;
	}

	@Override
	public ArrayList<Person> getPersons()
	{
		System.out.println( "getPersons method has been invoked." ) ;
		return persons ;
	}

	@Override
	public Person getPersonAt( String name )
	{
		System.out.println( "getPersonAt method has been invoked: " + name ) ;
		if ( name == null || name.isEmpty() )
		{
			throw new NullPointerException( "Name is null." ) ;
		}
		else
		{
			for ( Person person : persons )
			{
				if ( name.equals( person.get_nom() ) )
					{
						return person ;
					}
			}
		}
		return null ;
	}
	
	@Override
	public String token_generation()
	{
		byte[] array = new byte[20] ; // length is bounded by 7
	    new SecureRandom().nextBytes( array ) ;
	    return array.toString().substring( 3 , array.toString().length() ) ;
	    
	}

	@Override
	public String suppression_utilisateur( int id )
	{
		return "" ;
	}
}

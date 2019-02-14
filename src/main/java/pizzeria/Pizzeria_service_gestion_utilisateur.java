package pizzeria;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( name = "pizzeria_gestion_utilisateur" , targetNamespace = "http://pizzeria/gestion_utilisateur" )
public interface Pizzeria_service_gestion_utilisateur
{
	
	String inscription( @WebParam( name = "nom" ) String nom , @WebParam( name = "mot_de_passe" ) String mot_de_passe , @WebParam( name = "verification_mot_de_passe" ) String mot_de_passe_verification , @WebParam( name = "compte_administrateur" ) boolean is_admin ) ;
	
	String connexion( @WebParam( name = "nom" ) String nom , @WebParam( name = "mot_de_passe" ) String mot_de_passe ) ;
	
	String deconnexion( @WebParam( name = "token" ) String token ) ;
	
	ArrayList<Person> getPersons() ;
	
	Person getPersonAt( @WebParam( name = "numero_personne" ) String id ) ;
	
	String token_generation() ;
	
	String suppression_utilisateur( int id ) ;
}

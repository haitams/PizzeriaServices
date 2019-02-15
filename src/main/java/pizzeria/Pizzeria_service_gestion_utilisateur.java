package pizzeria;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 
 * @author  LUCK Bastien - OURKIA Yassin
 * Class to implement the UserManager service (Inscription, Connection)
 *
 */
@WebService( name = "pizzeria_gestion_utilisateur" , targetNamespace = "http://pizzeria/gestion_utilisateur" )
public interface Pizzeria_service_gestion_utilisateur
{
	/**
	 * Method to subscribe to the pizzeria service
	 * @param nom name of the user
	 * @param mot_de_passe password of the user
	 * @param verification_mot_de_passe password of the user
	 * @param admin check if the user is admin or customer
	 * @return message information about if the subscription was successfully done
	 */
	String inscription( @WebParam( name = "nom" ) String nom , @WebParam( name = "mot_de_passe" ) String mot_de_passe , @WebParam( name = "verification_mot_de_passe" ) String mot_de_passe_verification , @WebParam( name = "compte_administrateur" ) boolean is_admin ) ;
	/**
	 * Method to Login to the service of Pizzeria
	 * @param nom name of the user
	 * @param mot_de_passe password of the user
	 * @return message information about if the login was successfully done
	 */
	String connexion( @WebParam( name = "nom" ) String nom , @WebParam( name = "mot_de_passe" ) String mot_de_passe ) ;
	/**
	 * Method to logout from the Pizzeria service
	 * @param token token generated for every session
	 * @return message information about if the logout was done successfully
	 */
	String deconnexion( @WebParam( name = "token" ) String token ) ;
	/**
	 * Method of all users subscribed to the service
	 * @return the list of users
	 */
	ArrayList<Person> getPersons() ;
	/**
	 * Method to get a User from the list of all users
	 * @param id the id of the user wanted
	 * @return the user
	 */
	Person getPersonAt( @WebParam( name = "numero_personne" ) String id ) ;
	/**
	 * Method to delete user by permission of an admin
	 * @param personne admin user
	 * @param id the id of the user to be deleted
	 * @return message information if the user is deleted correctly
	 */
	String suppression_utilisateur(Person personne , int id ) ;
	/**
	 * Method to generate a random Token 
	 * @return random string token
	 */
	String token_generation() ;
	
}

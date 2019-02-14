package pizzeria;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * Class to implement the order service (take or cancel an order, add or delete pizza, 
 * @author LUCK Bastien - OURKIA Yassin
 *
 */
@WebService( name = "pizzeria_commandes" , targetNamespace = "http://pizzeria/commandes" )
public interface Pizzeria_service_commandes
{
	/**
	 * Method to command a pizza 
	 * @param nom_pizza name of the pizza
	 * @param quantiter the quantity of the order
	 * @return message information to indicate whether the command is taken or not
	 */
	String commande_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza , @WebParam( name = "nombre_a_acheter" ) int quantiter ) ;
	/**
	 * Method to cancel pizza 
	 * @param token a validate token
	 * @return message information to indicate whether the command is canceled or not
	 */
	String annuler_commande_pizza( @WebParam( name = "token" ) String token ) ;
	/**
	 * Method to add a pizza to the menu 
	 * @param nom_pizza name of the pizza to be added
	 * @param description the description of the pizza
	 * @param prix the price of the pizza
	 * @return message information to indicate whether the pizza is added or not
	 */
	String ajouter_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza , @WebParam( name = "description_pizza" ) String description , @WebParam( name = "prix_pizza" ) double prix ) ;
	/**
	 * Method to delete a pizza from the menu
	 * @param nom_pizza name of the pizza to be deleted
	 * @return message information to indicate whether the pizza is deleted or not
	 */
	String supprimer_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza ) ;
	/**
	 * Method to display the menu of the pizzeria
	 * @return the list of all pizza in the array list
	 */
	ArrayList<Pizza> get_liste_pizza() ;
	/**
	 * Method to get a Pizza from the list of pizza
	 * @param nom_pizza the name of the pizza 
	 * @return A Pizza information
	 */
	Pizza get_pizza_at( @WebParam( name = "nom_pizza" ) String nom_pizza ) ;
}

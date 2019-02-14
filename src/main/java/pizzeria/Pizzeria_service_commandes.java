package pizzeria;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( name = "pizzeria_commandes" , targetNamespace = "http://pizzeria/commandes" )
public interface Pizzeria_service_commandes
{
	String commande_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza , @WebParam( name = "nombre_a_acheter" ) int quantiter ) ;
	
	String annuler_commande_pizza( @WebParam( name = "token" ) String token ) ;
	
	String ajouter_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza , @WebParam( name = "description_pizza" ) String description , @WebParam( name = "prix_pizza" ) double prix ) ;
	
	String supprimer_pizza( @WebParam( name = "nom_pizza" ) String nom_pizza ) ;
	
	ArrayList<Pizza> get_liste_pizza() ;
	
	Pizza get_pizza_at( @WebParam( name = "nom_pizza" ) String nom_pizza ) ;
}

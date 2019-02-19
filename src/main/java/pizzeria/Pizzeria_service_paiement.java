package pizzeria;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( name = "pizzeria_paiement" , targetNamespace = "http://pizzeria/paiement" )
public interface Pizzeria_service_paiement
{
	/**
	 * Method to validate payment of an order by a validate token and an existing non payed order
	 * @param token a validate token 
	 * @param commande number of the order
	 * @return Set the status of the order, and display an information message of the operation done
	 */
	String payer_commande( @WebParam( name = "token" ) String token, @WebParam( name = "numero_commande" ) int commande ) ;
	
	/**
	 * Method to visualize the bill or the order if it's not yet payed
	 * @param token a validate existing token
	 * @param commande number of the order 
	 * @return the information about the order
	 */
	String previsionner_facture( @WebParam( name = "token" ) String token,  @WebParam( name = "numero_commande" ) int commande ) ;
}

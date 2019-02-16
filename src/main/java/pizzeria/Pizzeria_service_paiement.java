package pizzeria;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService( name = "pizzeria_paiement" , targetNamespace = "http://pizzeria/paiement" )
public interface Pizzeria_service_paiement
{
	/**
	 * 
	 * @param token
	 * @return
	 */
	String payer_commande( @WebParam( name = "token" ) String token ) ;
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	String previsionner_facture( @WebParam( name = "token" ) String token ) ;
}

package pizzeria;

import javax.jws.WebService;

@WebService( name = "pizzeria_paiement" , targetNamespace = "http://pizzeria/paiement" )
public interface Pizzeria_service_paiement
{
	String payer_commande() ;
}

package pizzeria;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_paiement" , serviceName = "pizzeria_paiement" , portName = "Pizzeria_paiement_port" )
public class Pizzeria_service_paiement_impl implements Pizzeria_service_paiement
{


	@Override
	public String payer_commande()
	{
		
		return "" ;
	}
}

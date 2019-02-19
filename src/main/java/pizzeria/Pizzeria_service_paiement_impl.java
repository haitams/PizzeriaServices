package pizzeria;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService( endpointInterface = "pizzeria.Pizzeria_service_paiement" , serviceName = "pizzeria_paiement" , portName = "Pizzeria_paiement_port" )
public class Pizzeria_service_paiement_impl implements Pizzeria_service_paiement
{


	private ArrayList<Person> personnes = Pizzeria_service_gestion_utilisateur_impl.personnes ;
	private ArrayList<Commande_pizza> commandes = Pizzeria_service_commandes_impl.commandes;
	
	public Pizzeria_service_paiement_impl() {
		
	}

	@Override
	public String payer_commande(String token, int numero_commande) {
		
		for(Person personne : personnes)
		{
			if(personne.get_token().equals(token))
			{
				for(Commande_pizza commande : commandes)
				{
					if(commande.get_id() == numero_commande && commande.get_token().equals(token) && commande.getStatus().equals("non payee"))
					{
						commande.setStatus("payee");
						return "Votre facture est comme suit : Pizzas : "+commande.get_nom_pizza()+
								" , Quantité : "+commande.get_quantiter()+
								" , Prix totale : "+commande.get_prix();
					}
				}
				return "Le numero de commande que vous avez saisi n'existe pas ";
			}
		}
		return "Votre token est invalide";
	}
	

	@Override
	public String previsionner_facture(String token, int numero_commande) {
		for(Person personne : personnes)
		{
			if(personne.get_token().equals(token))
			{
				for(Commande_pizza commande : commandes)
				{
					if(commande.get_id() == numero_commande && commande.get_token().equals(token))
					{
						return "Votre commande est comme suit : "+commande;
					}
				}
				return "Le numero de commande que vous avez saisi n'existe pas ";
			}
		}
		return "Votre token est invalide";
	}
}

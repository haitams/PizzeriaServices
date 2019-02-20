package pizzeria;

import javax.xml.ws.Endpoint;
/**
 * Main class to launch the services
 * @author LUCK BASTIEN - OURKIA YASSIN
 *
 */
public class Pizzeria_web_service_publisher
{
	public static void main( String[] args ) throws ClassNotFoundException
	{
		System.setProperty( "javax.xml.soap.SAAJMetaFactory" , "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl" ) ;
		Endpoint.publish( "http://localhost:9991/ws/pizzeria/gestion_utilisateur" , new Pizzeria_service_gestion_utilisateur_impl() ) ;
		Endpoint.publish( "http://localhost:9991/ws/pizzeria/commandes" , new Pizzeria_service_commandes_impl() ) ;
		Endpoint.publish( "http://localhost:9991/ws/pizzeria/paiement" , new Pizzeria_service_paiement_impl() ) ;
	}
}

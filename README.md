# Pizzeria : Services de gestion d'une pizzeria réalisé par LUCK Bastien - OURKIA Yassin


## Contenu
Dans cette application nous avons réalisé trois service pour la gestion d'une Pizzeria
* Gestion Utilisateur
* Gestion des commandes
* Gestion de paiement 

## Description de lancement : 

* Cloner le projet à partir de cette commande 

```bash
git clone https://github.com/yassinourkia/PizzeriaServices.git
```

* Deployer le projet localement 
Pour deployer les services localement il suffit de lancer les commandes suivantes

```bash
mvn clean package
java -cp "target/classes:target/dependency/*" pizzeria.Pizzeria_web_service_publisher
```
et vous pouvez visualiser les fichier wsdl dans un navigateur ou un SOAPui avec les liens suivants :

http://localhost:9991/ws/pizzeria/gestion_utilisateur?wsdl
http://localhost:9991/ws/pizzeria/commandes?wsdl
http://localhost:9991/ws/pizzeria/paiement?wsdl


* Deployer les service sur Docker

Vous pouvez également lancer les services et les heberger dans un serveur docker, pour se faire, faut tout d'abord s'assurer que vous avez bien installé la version de docker qui va avec la version de JDK11
vous pouvez la telecharger en utilisant la commande suivante :

```bash
docker pull tomcat:9.0.12-jre11-slim
```

Après vous lancer le serveur Docker et vous taper la commande suivante pour heberger les services dans le docker :

```bash
mvn clean package -P war
docker run --rm --name helloworldservice-tomcat -v $(pwd)/target/ws.war:/usr/local/tomcat/webapps/ws.war -it -p 8080:8080 tomcat:9.0.12-jre11-slim
```

et vous pouvez visualiser les fichier wsdl dans un navigateur ou un SOAPui avec les liens suivants :

http://localhost:8080/ws/pizzeria/gestion_utilisateur?wsdl
http://localhost:8080/ws/pizzeria/commandes?wsdl
http://localhost:8080/ws/pizzeria/paiement?wsdl



* Ouvrir un navigateur web et tester l'URL suivante : <http://localhost:8080/ws/notebookservice?wsdl> et visualiser le WSDL.

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

![screen shot 2019-02-20 at 15 46 45](https://user-images.githubusercontent.com/19637807/53101375-e72e1900-3529-11e9-94c0-d9ddb905e177.png)


et vous pouvez visualiser les fichier wsdl dans un navigateur ou un SOAPui avec les liens suivants :

> http://localhost:9991/ws/pizzeria/gestion_utilisateur?wsdl

![g_u](https://user-images.githubusercontent.com/19637807/53101608-69b6d880-352a-11e9-95f5-8943b32b000c.png)

> http://localhost:9991/ws/pizzeria/commandes?wsdl

![local](https://user-images.githubusercontent.com/19637807/53101479-1cd30200-352a-11e9-8045-fe3783aa8272.png)

> http://localhost:9991/ws/pizzeria/paiement?wsdl

![paiementlocal](https://user-images.githubusercontent.com/19637807/53101676-88b56a80-352a-11e9-880d-f2b36b18c54d.png)


* Deployer les service sur Docker

Vous pouvez également lancer les services et les heberger dans un serveur docker, pour se faire, faut tout d'abord s'assurer que vous avez bien installé la version de docker qui supporte la version de JDK (11)
vous pouvez la telecharger en utilisant la commande suivante :

```bash
docker pull tomcat:9.0.12-jre11-slim
```

Après vous lancez le serveur Docker et vous tapez la commande suivante pour heberger les services dans le docker :

```bash
mvn clean package -P war
```

![screen shot 2019-02-20 at 15 47 14](https://user-images.githubusercontent.com/19637807/53100853-dc26b900-3528-11e9-8588-3f2c44cf4e97.png)

```bash
docker run --rm --name helloworldservice-tomcat -v $(pwd)/target/ws.war:/usr/local/tomcat/webapps/ws.war -it -p 8080:8080 tomcat:9.0.12-jre11-slim
```
![screen shot 2019-02-20 at 15 48 03](https://user-images.githubusercontent.com/19637807/53101068-59522e00-3529-11e9-810e-f00793a016b6.png)

Maintenant vous pouvez visualiser les fichier wsdl dans un navigateur ou un SOAPui avec les liens suivants :

> http://localhost:8080/ws/pizzeria/gestion_utilisateur?wsdl

![screen shot 2019-02-20 at 15 48 51](https://user-images.githubusercontent.com/19637807/53101754-ac78b080-352a-11e9-8e21-aa187c5210b6.png)

> http://localhost:8080/ws/pizzeria/commandes?wsdl

![screen shot 2019-02-20 at 16 15 47](https://user-images.githubusercontent.com/19637807/53101881-ea75d480-352a-11e9-86fa-27906f4ed4c5.png)

> http://localhost:8080/ws/pizzeria/paiement?wsdl

![screen shot 2019-02-20 at 16 15 27](https://user-images.githubusercontent.com/19637807/53101851-de8a1280-352a-11e9-9fc3-6d83e4f42b39.png)

## La documentation
Pour generer et voir la documentation, tapez la commande suivante 

```bash
mvn javadoc::aggregate
```

Vérifiez Dans le dossier > target/ qu'un repertoir sous le nom de site est generé
vous trouvez la documentation dans > target/site/apidocs

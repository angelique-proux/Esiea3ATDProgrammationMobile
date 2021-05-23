# Programmation Mobile

## Projet de 3ème année, ESIEA, 2021

### Projet réalisé par Angélique PROUX

Création d'une application mobile programmée en Kotlin et utilisant deux API REST.

#### Description

UniversCity est une application sur laquelle il est possible de rechercher des universités dans n'importe quel pays.

#### Maquette

Sur la maquette ci-dessous, vous pouvez voir la navigation entre les pages ainsi qu'un exemple de contenu.

![Maquette](https://user-images.githubusercontent.com/72751313/119257640-74a7ba00-bbc6-11eb-8740-5d8c7e853235.png)


#### Contenu plus technique de l'application

L'application contient :

- deux écrans avec une liste d'éléments (écran Continents et écran Pays)

- deux écran avec le détail d'éléments (écran Pays Détail et écran Informations)

- un écran avec une liste d'universités et le détail d'un pays (écran Universités)

- trois appels WebService à Rest Countries. Cette première API Rest possède une base de données sur les pays du monde entier. Cette API est en anglais. Un premier appel retourne la liste des pays pour une région donnée, un second renvoie la liste des pays pour une langue donnée et un dernier retourne les informations d'un pays donné.

- un appel WebService à University-Domain-List. Cette deuxième API Rest possède une base de données sur les universités et écoles du supérieur des pays du monde entier. L'appel à l'API retourne la liste des universités d'un pays donné en arguments.

- des données stockées dans le cache (possibilité d'accéder hors réseau aux continents et pays déjà sélectionnés)

- utilisation d'un Singleton qui gère les appels Api

- utilisation du modèle de conception MVC (trois MVC implémentés : un pour contrôler l'affichage des continents, un deuxième pour l'affichage des pays et de leurs informations et un dernier qui contrôle l'affichage des universités)

- graphisme : implémentation de deux thèmes (vert et violet), utilisation de différentes polices, couleurs et images

- utilisation de notifications push (Firebase)* pour inviter le client à ouvrir l'application.

- utilisation d'alertes pour alerter l'utilisateur lors d'un non-fonctionnement (perte du réseau lors de l'appel à l'API)

- autres fonctionnalités : 
> possibilité de changer la langue de l'application (par défaut en anglais) de changer le thème, de renseigner un nom d'utilisateur, une location et une langue étudiée pour ensuite les utiliser
> possibilité d'ouvrir les liens vers les Apis et vers le github dans la page Information, et les liens vers les universités via la page Universités

* les notifications push Firebase nécessite l'ouverture de l'application Firebase pour être envoyées, il se peut que vous n'en recevez pas aux heures définies.

Ci-dessous vous trouverez les notifications planifiées sur Firebase et leur réception sur l'application.

Sur Firebase :

![NotificationPlanifiée](https://user-images.githubusercontent.com/72751313/119254736-62268400-bbb8-11eb-97cd-205d8228aa3f.png)

Sur le téléphone :

![NotificationPlanifiéeArrivée](https://user-images.githubusercontent.com/72751313/119254757-82eed980-bbb8-11eb-8356-867f6e3effa6.png)

![PremièreNotificationFirebase](https://user-images.githubusercontent.com/72751313/119254766-8e420500-bbb8-11eb-8c04-bb30ca09426a.png)

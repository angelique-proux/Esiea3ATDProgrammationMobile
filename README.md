# Programmation Mobile - UniversCity

## Projet de 3ème année, ESIEA, 2021

### Projet réalisé par Angélique PROUX

Création d'une application mobile programmée en Kotlin et utilisant deux API REST.

#### Description

UniversCity est une application sur laquelle il est possible de rechercher des universités dans n'importe quel pays.

#### Fonctionnement

##### > Accueil

Sur cette page, vous pouvez choisir de consulter la liste des continents, celle des pays situés sur son continent (renseigné dans les paramètres), celle des pays parlant la langue que vous souhaitez apprendre, le pays où vous habitez et les informations sur l'application.
Il vous suffit de cliquer sur l'un des six boutons. Vous pouvez également accéder aux paramètres via les trois points du haut de l'écran.
Voici un apercu du menu d'accueil :

![AppMenu](https://user-images.githubusercontent.com/72751313/119238868-97de5500-bb45-11eb-991f-fa537bad7b43.png)

##### > Liste des continents

Sur cette page, la liste des continents est montrée. Vous pouvez en choisir un pour accéder à la liste des pays associés.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :

![AppContinents](https://user-images.githubusercontent.com/72751313/119238913-d247f200-bb45-11eb-8c49-49993a83aec2.png)

##### > Liste des pays

Sur cette page, une liste de pays est montrée. Elle peut correspondre soit aux pays du continent choisi, soit aux pays où la langue choisie est une langue officielle.
Pour accéder au pays voulu, cliquez sur son nom ou sur son drapeau.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :

![AppPays](https://user-images.githubusercontent.com/72751313/119238925-e5f35880-bb45-11eb-8ddf-7b30fc3c7cc2.png)

##### > Informations sur le pays

Sur cette page sont montrées les informations concernant le pays sélectionné.
Vous y trouverez le nom du pays dans sa langue natale, le nom de sa capitale, ses langues officielles, sa population, sa superficie, son continent, sa monnaie et ses pays frontaliers.
Vous pouvez également consulter la liste des universités du pays.
Appuyez sur le bouton "retour au menu" pour recommencer votre recherche.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :

![AppPaysInfo](https://user-images.githubusercontent.com/72751313/119238931-f0155700-bb45-11eb-8707-7897373d04db.png)

##### > Universités enregistrées
Sur cette page, vous retrouverez le nom du pays sélectionné ainsi que le nombre d'universités ou écoles du supérieur trouvées.
Vous aurez également accès à la liste des universités. Pour consulter le site web de l'université qui vous plaît, il vous suffit de cliquer sur son nom. Une page web s'ouvrira ensuite à la bonne adresse.
Appuyez sur le bouton "retour au menu" pour recommencer votre recherche. Appuyez sur le bouton "retour au pays" pour revoir les informations du pays sélectionné.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :

![AppUniver](https://user-images.githubusercontent.com/72751313/119253448-93e81c80-bbb1-11eb-915c-0659d92c27e2.png)
![AppLienUni](https://user-images.githubusercontent.com/72751313/119253928-b7ac6200-bbb3-11eb-96f2-2f8a4230d06e.png)

##### > Informations sur l'application
Sur cette page, vous trouvez les informations essentielles sur l'application : son nom et logo, le nom de sa créatrice, sa version, son objectif et les langues supportées.
Vous pouvez également ouvrir la page des deux api en cliquant sur leur adresse et cette page sur github en cliquant sur "cliquez ici".
Vous pouvez toujours retourner au menu et accéder aux paramètres en haut de l'écran.
Voici un aperçu de cette page :


##### > Réglages
Sur cette page, vous pouvez renseigner vos informations. Vous pouvez renseigner un nom d'utilisateur, une localisation (continent et pays), une langue étudiée et celle choisie pour l'application.
Vous pouvez également choisir le thème de l'application entre deux : vert et rouge.
Voici un aperçu de cette page :

![AppParametres](https://user-images.githubusercontent.com/72751313/119238908-c9572080-bb45-11eb-89e5-217abf54705a.png)

#### À savoir

##### > Réseau

L'application utilisant deux Api Rest, il est nécessaire d'activer le wifi ou les données cellulaires du téléphone pour recevoir les données.
Si votre wifi est désactivé et que vous n'avez pas encore consulté les pays de votre continent par exemple, la liste correspondante ne s'affichera pas. Un message d'alerte viendra vous rappeler d'activer votre wifi. En cliquant sur le message, vous serez redirigés vers le menu.
L'appel ne s'effectuant qu'une seule fois, il vous faudra retourner en arrière pour accéder à la liste une fois votre wifi activé.

##### > Langues

L'application est disponible en français, en anglais et en allemand. Par défaut, l'application est en anglais mais vous pouvez choisir votre langue dans les paramètres.

##### > Notifications

Des notifications vous sont envoyées chaque jour à 10H30 et à 15h pour vous rappeler de l'utiliser pour trouver l'université qui vous correspond.
Voici un exemple de notifications :

![NotificationPlanifiéeArrivée](https://user-images.githubusercontent.com/72751313/119254087-a44dc680-bbb4-11eb-8bbc-26a21e01bff4.png)

Ces notifications sont envoyées par le site firebase.

##### > Alertes

L'application vous envoie des alertes lorsqu'une api n'a pas pu être atteinte. Ces alertes vous rappellent d'activer votre wifi pour accéder aux données que vous n'avez pas consulté auparavant.
Voici un exemple d'alertes :

![AppAlerte](https://user-images.githubusercontent.com/72751313/119254272-b67c3480-bbb5-11eb-9f32-bf9bc8c60bd1.png)

Pour avoir un exemple d'alerte sans déactiver votre wifi, cliquez sur "message rapide" dans le menu du haut (voir ci-dessous).

![AppMenu2](https://user-images.githubusercontent.com/72751313/119238900-bfcdb880-bb45-11eb-9487-53f098d21778.png)

##### Informations complémentaires

Pour plus d'informations, veuillez consulter le fichier [Informations](https://github.com/angelique2000/Esiea3ATDProgrammationMobile/blob/master/application_informations/Informations.md)

Vous y trouverez une maquette du projet, son contenu de façon plus détaillée ainsi qu'un schéma de son architecture.
# Programmation Mobile

## Projet de 3ème année, ESIEA, 2021

### Projet réalisé par Angélique PROUX

Création d'une application mobile programmée en Kotlin et utilisant deux API REST.

#### Description

UniversCity est une application sur laquelle il est possible de rechercher des universités dans n'importe quel pays.

#### Fonctionnement

##### > Acceuil

Sur cette page, vous pouvez choisir de consulter la liste des continents, celle des pays situés sur son continent (renseigné dans les paramètres), celle des pays parlant la langue que vous souhaitez apprendre, le pays où vous habitez et les informations sur l'application.
Il vous suffit de cliquer sur l'un des six boutons. Vous pouvez également accéder aux paramètres via les trois points du haut de l'écran.
Voici un apercu du menu d'acceuil :


##### > Liste des continents

Sur cette page, la liste des continents est montrée. Vous pouvez en choisir un pour accéder à la liste des pays associés.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :


##### > Liste des pays

Sur cette page, une liste de pays est montrée. Elle peut correspondre soit aux pays du continent choisi, soit aux pays où la langue choisie est une langue officielle.
Pour accéder au pays voulu, cliquez sur son nom ou sur son drapeau.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :


##### > Informations sur le pays

Sur cette page sont montrées les informations concernant le pays sélectionné.
Vous y trouverez le nom du pays dans sa langue natale, le nom de sa capitale, ses langues officielles, sa population, sa superficie, son continent, sa monnaie et ses pays frontaliers.
Vous pouvez également consulter la liste des universités du pays.
Appuyez sur le bouton "retour au menu" pour recommencer votre recherche.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :


##### > Universités enregistrées
Sur cette page, vous retrouverez le nom du pays sélectionné ainsi que le nombre d'universités ou écoles du supérieur trouvées.
Vous aurez également accès à la liste des universités. Pour consulter le site web de l'université qui vous plaît, il vous suffit de cliquer sur son nom. Une page web s'ouvrira ensuite à la bonne adresse.
Appuyez sur le bouton "retour au menu" pour recommencer votre recherche. Appuyez sur le bouton "retour au pays" pour revoir les informations du pays sélectionné.
Les paramètres sont toujours accessibles en haut de l'écran.
Voici un aperçu de cette page :

##### > Informations sur l'application
Sur cette page, vous trouvez les informations essentielles sur l'application : son nom et logo, le nom de sa créatrice, sa version, son objectif et les langues supportées.
Vous pouvez également ouvrir la page des deux api en cliquant sur leur adresse et cette page sur github en cliquant sur "cliquez ici".
Vous pouvez toujours retourner au menu et accéder aux paramètres en haut de l'écran.
Voici un aperçu de cette page :


##### > Réglages
Sur cette page, vous pouvez renseigner vos informations. Vous pouvez renseigner un nom d'utilisateur, une localisation (continent et pays), une langue étudiée et celle choisie pour l'application.
Vous pouvez également choisir le thème de l'application entre deux : vert et rouge.

#### À savoir

##### Réseau

L'application utilisant deux Api Rest, il est nécessaire d'activer le wifi ou les données cellulaires du téléphone pour recevoir les données.
Si votre wifi est désactivé et que vous n'avez pas encore consulté les pays de votre continent par exemple, la liste correspondante ne s'affichera pas. Un message d'alerte viendra vous rappeler d'activer votre wifi.
L'appel ne s'effectuant qu'une seule fois, il vous faudra retourner en arrière pour accéder à cette liste.

##### Langues

L'application est disponible en français, en anglais et en allemand. Par défaut, l'application est en anglais mais vous pouvez choisir votre langue dans les paramètres.
volley
======

Logiciel d'aide à la mise en place de stratégies de volley-ball.

***TO DO***

***GIT***

Le répertoire src correspond au workspace Eclipse

Il existe un client git pour windows téléchargeable ici :
http://windows.github.com/

Il existe aussi un addon Eclipse mais c'est un peu la misère, je vous déconseille.

Il y a un très bon tutoriel pour git ici :
http://www.siteduzero.com/informatique/tutoriels/gerez-vos-codes-source-avec-git

Vous devez surtout vous familiariser avec ces commandes :
status, add, commit, pull, push

Dans l'ordre, vous devez :
- Faire un status pour voir quels sont les fichiers qui ont été modifiés,
- Là vous pouvez faire vos modifications,
- Eventuellement faire un add pour ajouter les fichiers non versionnés,
- Faire un pull pour récupérer le code présent dans le dépot.
- Puis faire un commit pour envoyer vos modifications sur le dépot.

***Configuration d'Eclipse***

Workspace :
Travaillez sur celui du projet (le dossier src du dépot), pas sur votre workspace perso!!

Pour que les caractères soient en utf-8 :
-> Window, General, Workspace, Text file encoding : UTF-8

Pour la javadoc (voir plus bas)
-> Project, Generate Javadoc..., sélectionner le programme javadoc.
	Par défaut, sur Windows : C:\ProgramFiles\java\jdk1.6.0_01\bin\javadoc.exe

***Javadoc***
Pour ne pas s'embéter à rédiger la documentation, nous allons de la demander à Eclipse de la générer.
Pour cela, il faut insérer des commentaires petit à petit dans le code, avant chaque classe et chaque méthode.
Il faut placer ces commentaires juste au dessus de la classe ou méthode à commenter.
Il existe des tags qui seront compréhensibles par la javadoc, ils commencent par '@'.

Cela doit ressembler à ça :

/**
 * Description de la methode.<br/>
 * Il est necessaire d'insérer les '<br/>' pour faire plusieurs lignes.
 * @author Votre nom et prénom (si la méthode a été réalisée à plusieurs, mettre tous les noms, séparés par une virgule).
 * @param _chaine Description du 1er parametre.
 * @param _i Description du 2eme parametre.
 * @return Description de la valeur de retour.
 * @see package.Classe#methodeInteresante()
 */
public Methode (String _chaine, int _i)
{...

Pour générer la javadoc : Project, Generate Javadoc... , comme vu plus haut.

***Généralités sur le code***
Respect du modèle MVC.
Toutes les actions seront traitées dans le controleur.
On créera une nouvelle classe dans un nouveau fichier pour chaque écouteur.

***Normalisation du code***
Les noms des paramètres d'une méthodes seront précédés par un '_' pour les différencier des variables déclarées dans la méthode.
ex:
public Methode (String _chaine, int _i)

Les accolades seront toujours sur une nouvelle ligne
ex:
public Methode ()
{
...
}

Les arguments de la classe seront toujours appelés par this
ex:
this.bouton = new JButton ("Bouton");



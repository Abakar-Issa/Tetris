# Tetris
Jeu d'assemblage de forme : il s'agit d'assembler des piéces existantes sur un plateau de manière à ce qu'elles occupent le moins de place possible. Un score est affiché à la fin du jeu. Le joueur à un nombre limiter d'actions ( 80 ) pour finir le jeu. On peut sélectionner une piéce et faire plusieurs actions avec : rotation gauche ( appuyer sur la lettre a) , rotation à droite ( appuyer sur la lettre z ) , déplacement avec les fléches du clavier. 
Ce jeu ne se joue que sur PC et est à lancer en ligne de commande. 
# Pour lancer le jeu 
Il faut d'abord avoir installer java sur son pc. En suite,une fois le package télécharger, ouvrez un terminal et aller dans le répertoire src (cd src). 
Avant de tapez les commandes suivantes, créer un nouveau dossier build (vide) dans le dossier src. 

javac -d build *.java

java -cp build Test.java

Une interface graphique s'affichera avec le plateau du jeu en état initial. Vous pouvez jouer maintenant !!

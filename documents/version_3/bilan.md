Pendant l'itération 3 nous avons choisi 2 fonctionnalités :
  - Mur deployable qui consiste à rendre certain mur déplaçable, nous avons choisi de les représenter par des caisses 
    ces caisses peuvent être déplacé par le personnage lorsqu'il avance vers elles.
  - Probleme de Sokoban qui consiste à ajouter des cases d'arrivées pour les caisses, le jeu se termine lorsque toutes les 
    caisses sont sur une case d'arrivée

  Nous avons réussi à faire ces 2 fonctionnalités dans les temps, pour cela nous avons du ajouter 3 classes : **Cases** qui regroupe les positions en booléen, **Caisses** qui hérite de Positions qui représente les caisses du jeu, et aussi **EmplacementsCaisse** qui représente les arrivées


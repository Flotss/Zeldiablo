### Pendant l'itération 3 nous avons choisi 2 fonctionnalités :
  - Mur déplaçable qui consiste à rendre certain mur déplaçable, nous avons choisi de les représenter par des caisses 
    ces caisses peuvent être déplacé par le personnage lorsqu'il avance vers elles.
  - Problème de Sokoban qui consiste à ajouter des cases d'arrivées pour les caisses, le jeu se termine lorsque toutes les 
    caisses sont sur une case d'arrivée

Nous avons réussi à concevoir et réaliser ces 2 fonctionnalités.

### Solution : 
- Pour ajouter les fonctionnalités, nous avons dû ajouter 3 classes : **Cases** qui regroupent les positions en booléen, **Caisses** qui héritent de **Cases** qui représente les caisses du jeu, et aussi **EmplacementsCaisse** qui hérite aussi de **Cases** et représente les arrivées des caisses.
- De plus pour pouvoir créer les caisses et leurs emplacements, nous avons dû modifier le constructeur de **Labyrinthe**
La méthode deplacerPerso a dû être modifié pour gérer la collision avec les caisses et le déplacement de ces dernières au travers d'une méthode deplacerCaisse
Pour pouvoir afficher les caisses, nous avons dû modifier la classe **LabyDessin** pour qu'elle puisse afficher les caisses et les emplacements d'arrivées.


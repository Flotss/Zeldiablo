### Pendant l'itération 5 nous avons choisi 2 fonctionnalités :
- Gestion d'un labyrinthe multi-étages, qui consiste à ajouter plusieurs étages au jeu et permettre au personnage de changer d'étage
  grâce à un étage lorsque l'étage actuel est fini c'est à dire lorsque toutes les caisses sont sur les emplacements d'arrivées.
  ces caisses peuvent être déplacé par le personnage lorsqu'il avance vers elles.
- Affichage avec des sprites, qui consiste à changer les formes du labyrinthe par des images et rendre notre jeu plus attractif.

Nous avons réussi à concevoir et réaliser ces 2 fonctionnalités.

### Solution :
- Pour ajouter les images nous avons utilisé une classe **Sprite** qui permet d'initialiser les images et dans la classe **LabyDessin**
  nous chargeons les images la première fois et ensuite nous les réutilisons. Nous avons ensuite modifié la méthode dessiner pour que l'affichage
  n'affiche plus des rectangle ou des cercles mais les images.

- Fonctionnalité:
1. Mur deplacable (caisse) (10.1) : MANGIN Florian, BAUBY Gaspard et BERNARD Julien

2. Probleme de Sokoban (10.2) : BERNARD Julien, SIMONIN Enzo et MANGIN Florian

3. Sol verglacé (10.3) : Bernard Julien et MANGIN Florian

4. Propulsion de mur déplaçable (10.4) : Bernard Julien

5. Gestion d'un labyrinthe multi-étages (1.8): BERNARD Julien et BAUBY Gaspard

6. Affichage avec des sprites (11.1) : MANGIN Florian et SIMONIN Enzo

- Points important 

    - BERNARD Julien :
L'un des points que je trouve important dans ce sujet est la gestion des escaliers et l'adaptation avec la 
fonctionnalité sokoban. En effet, nous avons fait en sorte que l'escalier ne soit affiché uniquement quand
tous les emplacements de caisses possède une caisse dessus (lorsqu'une caisse est déplacée apres ce point,
l'escalier se cache de nouveau). Il a donc fallu gérer l'affichage et le masquage de l'escalier tout en 
gérant le fait que l'escalier ne soit pas prenable s'il n'est pas affiché. Nous avons aussi du gérer la
nouvelle generation.
    - BAUBY Gaspard : 
    - MANGIN Florian : Le point que je trouve important est la gestion des caisses. En effet, il y avait beaucoup de critères à respecter, les caisses devait être déplaçables s'il n'y a pas d'obstacle, mais aussi que la gestion du déplacement avec les cases glacée.
    - SIMONIN Enzo : 
L'un des points les plus importants selon moi est l'affichage du labyrinthe avec des sprites (les murs, les caisses, les emplacements 
de caisse) les images sont chargées une seule fois au debut de l'application et donc ne surcharge pas le programme (comme le jeu fonctionne
avec 10 images par seconde, elle serait chargée 10 fois par secondes). Les sprites rendent le jeu plus lisible et plus jouable.
  

- Conclusion/bilan
Durant ce projet, nous devions réaliser une application de labyrinthe avec diverses fonctionnalités. 
Nous avons choisi de nous orienter vers un jeu sokoban avec étages. Nous avons réussi toutes les fonctionnalitées, et
leurs critères, envisagées. Une fois toutes les fonctionnalités finis, nous n'avons constaté aucuns bug et tous les
critères de validation sont bien respecté.
- Observations sur le projet :
Durant ce projet, nous avons fait quelques erreurs de conception, notamment sur le choix de représentation des cases.
Nous avons choisi de représenté toutes les formes de cases séparément alors que nous aurions pu toutes les rassembler
sous une même classe mère et ainsi avoir un unique tableau de "cases" contenant différents type de cases. 
Cependant, nos fonctionnalités fonctionnent correctement et est pour le moment pas trop chargé (ce qui aurait surement
changé avec plusieurs titrations supplémentaires).
Nous avons aussi fait quelques erreurs sur les diagrammes de classes et de séquences qui aurait pu être nettement 
simplifiés, notamment les diagrammes de séquences. En effet, lors de la réalisation des diagrammes de séquences,
j'ai voulu représenter ce que faisait la classe précisément si peut que le diagramme de classe se transforme globalement
en algorithme ce qui est un problème pour la lecture de ce dernier.





Remarques :
Dans les digrammes de classe je n'ai pas réussis à changé la couleur du texte des nouvelles méthodes.
Le diagramme de classe final se trouve dans la version 5

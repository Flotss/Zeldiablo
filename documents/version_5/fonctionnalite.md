1. Gestion d'un labyrinthe multi-étages (1.8): BERNARD Julien
- Descriptif :
    - Le labyrinthe doit être constitué de plusieurs étages
    - Chaque étage doit correspondre a un niveau particulier
    - Pour changé d'étages on utilise des escaliers
- Critères de validation :
    - Les escaliers sont des cases traversables par le héros et les monstres.
    - Lorsque le héros se trouve sur un escalier, il peut l'activer et il change alors de
    niveau.
    - Les monstres du niveau où le héros se trouvait avant l'escalier n'apparaissent pas
    dans l'étage supérieur/inférieur. Ils restent à leur position et conservent leur points
    de vie.
    - De nouveaux monstres peuvent être présents à l'étage supérieur en fonction du
    descriptif du niveau.
    - Le Héros arrive aux mêmes coordonnées dans l'étage supérieur/inférieur après
    avoir emprunté les escaliers.
    - Les escaliers peuvent être de deux types : un escalier qui monte ou un escalier qui
    descend.
    - Les escaliers sont empruntables dans les deux sens : un escalier qui monte vers un
    étage possède un escalier qui descend à la même position dans l'étage supérieur
    (et inversement).
- Remarque :
    - Nous allons lié cette fonctionnalité avec la fonctionnalité sokoban
    - Une fois les caisse déplacé sur tous les emplacements des caisses, un escalié
     s'ouvrira pour accédé aux prochain etage


2. Affichage avec des sprites (11.1)
- Descriptif :
    - Nous allons utiliser des sprites pour afficher les objets du jeu à la place des cercles, rectangles, etc.
- Critère de validation :
    - Les murs, le sol, les caisses, les emplacement de caisse et le personnage doivent etre représenté par des sprites
    - Les sprites doivent être chargés à l'initialisation du jeu
    - Les sprites doivent être affichés à la bonne position
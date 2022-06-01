1. Sol verglacé (10.3) : Bernard Julien
- Descriptif :
  - des cases du labyrinthe sont recouvertes de glace
  - si un mur ou le personnage est déplacé sur ces cases, ce dernier continue son déplacement jusqu'à atteindre une case non glacé
- Critères de validation :
  - Les containers se comportent comme des murs déplaçables.
  - Quand il glisse, un mur déplaçable s'arrête dès qu'il arrive sur une case normale.
  - Quand il glisse, un mur déplaçable s'arrête dès qu'il rencontre un obstacle.
- Remarque :
  - Il faut faire attention au cas où l'on pousse le mur sur une case glacée et un mur derriere

2. Propulsion de mur déplaçable (10.4)
- Descriptif :
  - le joueur doit disposer d'une touche pour propulser les murs déplaçables (combiné avec une touche de déplacement)
  - le mur déplaçable se déplace jusqu'à atteindre un mur
- Critères de validation :
  - Le mur avance dans la direction proposée
  - Lorsqu'il s'arrète, la case derrière lui contient un obstacle (mur, mur déplaçable, monstre, ...)
  - Lorsqu'on appuie sur la touche dédiée à la propulsion et qu'on appuie sur une touche de direction,
    le personnage ne se déplace pas (pour ne pas confondre avec le fait de propulser un mur avec le fait de se
    déplacer en poussant un mur).
  - Si on propulse un mur alors qu'il a déjà un obstacle derrière lui, le mur ne bouge pas
  - Seuls les murs déplaçables peuvent être propulsés

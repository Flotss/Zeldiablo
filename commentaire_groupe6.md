Groupe 6
Gaspard BAUBY
Julien BERNARD
Florian MANGIN
Enzo SIMONIN


# commentaires

## fonctionnalités V3	

- ok pour la liste de fonctionnalités et la répartition

## diagrammes

- votre diagramme de classe ne répond pas aux attentes de conception.
  - l'objectif n'est pas de mettre des tableaux d'entiers, mais de définir des concepts à réutiliser (par exemple le concept de caisse)
  - en partant dans cette direction, vous allez passer à côté des objectifs du projet qui consistent justement à structurer votre code à l'aide de classes (et de méthodes).

- concernant les diagrammes de séquence
  - penser à mettre aussi les fichiers images résultant dans votre dépôt (pas juste les fichiers plantuml)
  - vos appels de méthode dans "DeplacerCaisse" ne sont pas corrects (par exemple deplacerPerso tel que dessiné est censé correspondre à un constructeur car la flèche pointe sur la case)
  - les appels de méthodes d'un objet sur lui même sont mal représentés : il manque la flèche de retour, et il faut créer une période d'activation pour représenter cette seconde méthode (vous avez alors un rectangle dans un rectangle).

- il semble que vous n'avez qu'un seul diagramme de séquence malgré les trois fichiers différents. Y-a-t-il eu un problème dans votre dépôt ?

- pour bien faire apparaitre les concepts et les méthodes, il faut définir la classe Caisse et l'utiliser. Cela fera apparaitre des méthodes dans votre diagramme de séquence et rendra les choses plus intéressantes.

- enfin, un diagramme de séquence représente des objets et non des classes (cf mémo diagramme de séquence). Les noms des objets dans votre diagramme ne sont donc pas corrects. Ils doivent être de la forme nomObjet:nomClasse

## Code

- j'ai regardé votre code et j'ai vu les  cases glacées qui correspondent à l'itération 4.
  - j'aurai les mêmes remarques que pour l'itération 3, vous avez représenté cela avec des tableaux d'entiers. Or, en faisant cela, vous avez un problème : vous ne représentez pas le concept de case glacée sous la forme d'une classe et cela va nuire à (1) la lisibilité de votre application (2) la structure de votre application - par exemple si vous définissez le concept de case, vous pouvez définir le concept de case glacée (qui est une case particulière). 
  - Cette manière d'aborder les choses est centrale dans la conception orientée objet et c'est tout le principe de la phase de conception de réfléchir à l'organisation de votre code (c'est justement cela qui sera évalué dans la SAE).

Vous devez vraiment prendre le temps de réfléchir aux concepts et créer les classes correspondantes. Dans le cas contraire, la classe Labyrinthe qui va devenir trés grosse en terme de nombre de lignes et va devenir de plus en plus complexe à maintenir.

## bilan 

il manque un fichier bilan dans votre version3 qui fasse le point sur ce que vous avez codé et validé.

# Bilan

Vous avez une bonne base pour le début de la SAE et vous avez déjà avancé sur des fonctionnalités évoluées.

Cependant, il faut vraiment prendre le temps de proposer une conception structurée avec des classes et des méthodes. C'est justement tout le travail attendu dans le cadre de la SAE.

Utiliser uniquement des tableaux 
(1) va nuire à la qualité de votre code (classe Labyrinthe avec beaucoup de lignes, ... etc ..) et à sa lisibilité
(2) va vous empecher d'avoir des diagrammes de séquence intéressants (car tout est dans les attributs sous forme de tableau)
(3) va vous empêcher de faire évoluer votre code
(4) et au final, va vous faire passer à côté de l'objectif de la SAE (qui est justement de concevoir une application).

Ce serait dommage d'autant plus que vous travaillez sur le projet. Il me semble ainsi important de changer de direction dans votre manière de développer votre application.

Evaluation actuelle (entre A et F) => C 
(travail sérieux, mais, le projet que vous développez ne répond pas exactement aux attentes - je pense que c'est simplement une mauvaise compréhension des attentes : il faut corriger cela en créant d'autres classes représentant les concepts que vous introduisez dans votre jeu pour bien répondre aux attentes de la SAE).

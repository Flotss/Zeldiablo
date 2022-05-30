package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

import static gameLaby.laby.Labyrinthe.*;

public class LabyJeu implements Jeu {

  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  private Labyrinthe laby;


  public LabyJeu(String nomFichier) throws IOException {
    this.laby = new Labyrinthe(nomFichier);
  }

  /**
   * methode mise a jour du jeu
   *
   * @param secondes temps ecoule depuis la derniere mise a jour
   * @param clavier  objet contenant l'état du clavier'
   */
  @Override
  public void update(double secondes, Clavier clavier) {
    if (clavier.haut) {
      laby.deplacerPerso(HAUT);
    } else if (clavier.bas) {
      laby.deplacerPerso(BAS);
    } else if (clavier.gauche) {
      laby.deplacerPerso(GAUCHE);
    } else if (clavier.droite) {
      laby.deplacerPerso(DROITE);
    }
  }

  /**
   * initialisation du jeu
   */
  @Override
  public void init() {
    // pas d'initialisation particuliere
  }

  /**
   * verifie si le jeu est fini
   *
   * @return booleen true si le jeu est fini
   */
  @Override
  public boolean etreFini() {
    return laby.etreFini();
  }

  /**
   * Getter du labyrinthe
   * @return
   */
  public Labyrinthe getLaby() {
    return laby;
  }
}

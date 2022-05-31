package gameLaby.laby;

import gameLaby.laby.utils.Position;

import static gameLaby.laby.Labyrinthe.getSuivant;

public class Caisses extends Position {

  boolean[][] murs;
  /**
   * Constructeur de la classe Position
   *
   * @param x coordonnée x
   * @param y coordonnée y
   */
  public Caisses(int x, int y) {
    super(x, y);
    this.murs = new boolean[x][y];
  }

  /**
   * Deplace la caisse en fonction de la direction.
   *
   * @param x         Coordonnee x de la caisse
   * @param y         Coordonnee y de la caisse
   * @param direction Direction du personnage
   * @return true si la caisse a pu se deplacer, false sinon
   */
  public boolean deplacerCaisse(int x, int y, String direction) {
    int[] suivante = getSuivant(x, y, direction);
    int[] precedente = {x,y};
    boolean deplacement = false;

    // si c'est pas un mur, on effectue le deplacement
    if (caseDisponible(suivante[0], suivante[1])) {
      // on met a jour la caisse
      this.pos[precedente[0]][precedente[1]] = false;
      this.pos[suivante[0]][suivante[1]] = true;
      deplacement = true;
    }
    return deplacement;
  }

  /**
   *
   * @param x
   * @param y
   */
  void ajoutMurs(int x, int y) {
    this.murs[x][y] = true;
  }

  boolean caseDisponible(int x, int y) {
    return !murs[x][y] && !this.pos[x][y];
  }
}

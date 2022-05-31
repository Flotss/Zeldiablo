package gameLaby.laby;

import gameLaby.laby.utils.Cases;

public class Caisses extends Cases {

  /**
   * Constructeur de la classe Cases
   *
   * @param x coordonnée x
   * @param y coordonnée y
   */
  public Caisses(int x, int y) {
    super(x, y);
  }

  /**
   * Deplace la caisse en fonction de la direction.
   *
   * @param x         Coordonnee x de la caisse
   * @param y         Coordonnee y de la caisse
   * @return true si la caisse a pu se deplacer, false sinon
   */
  public void deplacer(int x, int y, int dx, int dy) {
    this.getPos()[x][y] = false;
    this.getPos()[dx][dy] = true;
  }

}

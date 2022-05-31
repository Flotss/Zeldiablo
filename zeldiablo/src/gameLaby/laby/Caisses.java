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
   * @param x  Coordonnee x de la caisse ancienne position
   * @param y  Coordonnee y de la caisse ancienne position
   * @param dx Coordonnee x de la caisse nouvelle position
   * @param dy Coordonnee y de la caisse nouvelle position
   */
  public void deplacer(int x, int y, int dx, int dy) {
    this.getPos()[x][y] = false;
    this.getPos()[dx][dy] = true;
  }

}

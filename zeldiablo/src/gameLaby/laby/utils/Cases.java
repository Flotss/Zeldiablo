package gameLaby.laby.utils;

public class Cases {
  /**
   * Attributs de la coordonnée
   */
  public boolean [][] pos;


  /**
   * Constructeur de la classe Cases
   *
   * @param x coordonnée x
   * @param y coordonnée y
   */
  public Cases(int x, int y) {
    this.pos = new boolean[x][y];
  }

  /**
   * Ajoute une position d'un caisse
   * @param x
   * @param y
   */
  public void ajouter(int x, int y) {
    this.pos[x][y] = true;
  }

  /**
   * Etre present sur la position
   * @param x coordonnée x
   * @param y coordonnée y
   * @return true si la position est presente
   */
  public boolean etrePresent(int x, int y) {
    return this.pos[x][y];
  }
}

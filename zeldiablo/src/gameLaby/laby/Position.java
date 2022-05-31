package gameLaby.laby;

import java.util.Objects;

public class Position {
  /**
   * Attributs de la coordonnée
   */
  private int x;
  private int y;


  /**
   * Constructeur de la classe Position
   *
   * @param x coordonnée x
   * @param y coordonnée y
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Retourne la coordonnée x
   * @return coordonnée x
   */
  public int getX() {
    return this.x;
  }

  /**
   * Retourne la coordonnée y
   * @return coordonnée y
   */
  public int getY() {
    return this.y;
  }

  /**
   * Change la coordonnée x
   * @param x coordonnée x
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Change la coordonnée y
   * @param y coordonnée y
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Compare deux positions
   * @param o objet à comparer
   * @return true si les positions sont égales sinon false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return x == position.x && y == position.y;
  }

  /**
   * Compare la position a deux coordonnées
   * @param x coordonnée x
   * @param y coordonnée y
   * @return true si les coordonnées sont égales sinon false
   */
  public boolean equals(int x, int y) {
    return this.x == x && this.y == y;
  }

  /**
   * Compare la position avec un tableau de coordonnées
   * @param tab tableau de coordonnées
   * @return true si les coordonnées sont égales sinon false
   */
  public boolean equals(int[] tab) {
    return this.x == tab[0] && this.y == tab[1];
  }
}

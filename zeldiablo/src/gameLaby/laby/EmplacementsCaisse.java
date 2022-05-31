package gameLaby.laby;

import gameLaby.laby.utils.Cases;

public class EmplacementsCaisse extends Cases {
  /**
   * Constructeur de la classe Cases
   *
   * @param x coordonnée x
   * @param y coordonnée y
   */
  public EmplacementsCaisse(int x, int y) {
    super(x, y);
  }

  /**
   * Methode etreFini qui vereifie que toutes les caisses sont sur les emplacments
   * @param c caisses
   * @return true si toutes les caisses sont sur les emplacements, sinon false
   */
  public boolean etreFini(Caisses c) {
    boolean fini = true;
    for (int i = 0; i < c.pos.length; i++) {
      for (int j = 0; j < c.pos[i].length; j++) {
        if (c.pos[i][j] != this.pos[i][j]) {
          fini = false;
          break;
        }
      }
    }
    return fini;
  }


}

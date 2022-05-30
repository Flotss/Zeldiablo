import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestLabyrinthe {
    @Test
    public void methodes() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

        // Methode a teste
        laby.deplacerPerso("Haut");
        laby.deplacerCaisse(17, 10, "Haut");
        laby.etreFini();
        laby.caseDisponible(12, 10);

    }
    @Test
    public void caseDisponible() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

        //Verification
        assertTrue(laby.caseDisponible(2,1)); // case libre
        assertFalse(laby.caseDisponible(1,1)); // Case mur
        assertFalse(laby.caseDisponible(6,2)); // Case caisse

    }

    @Test
    public void deplacerCaisse() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

        //Verification de la position de la caisse
        assertTrue(laby.getCaisse(17, 10));

        //Deplacement de la caisse avec la methode
        laby.deplacerCaisse(17, 10, Labyrinthe.HAUT);

        //Verification de la position de la caisse
        assertTrue(laby.getCaisse(17, 9));

    }


    @Test
    public void deplacerPersoEtCaisse() throws IOException {
      // Initialisation
      Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

      //Methode a tester
      for (int i = 0; i< 2; i++) laby.deplacerPerso("Haut");

      //Verification
      assertTrue(laby.pj.etrePresent(17,10));
      assertTrue(laby.getCaisse(17,9));
    }

  @Test
  public void emplacementSortieCaisse() throws IOException {
    // Initialisation
    Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

    //Verification de la position des sorties
    assertTrue(laby.contientCaisse(6,1));
    assertTrue(laby.contientCaisse(17,1));
    assertTrue(laby.contientCaisse(4,7));
    assertTrue(laby.contientCaisse(10,9));
  }

}

import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestLabyrinthe {
    @Test
    public void test01_methodes() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

        // Methode a teste
        laby.deplacerPerso("Haut");
        laby.deplacerCaisse(17, 10, "Haut");
        laby.etreFini();
        laby.caseDisponible(12, 10);

    }
    @Test
    public void test02_caseDisponible() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

        //Verification
        assertTrue(laby.caseDisponible(2,1)); // case libre
        assertFalse(laby.caseDisponible(1,1)); // Case mur
        assertFalse(laby.caseDisponible(6,2)); // Case caisse

    }

    @Test
    public void test03_deplacerCaisse() throws IOException {
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
    public void test04_deplacerPersoEtCaisse() throws IOException {
      // Initialisation
      Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

      //Methode a tester
      for (int i = 0; i< 2; i++) laby.deplacerPerso("Haut");

      //Verification
      assertTrue(laby.getPj().etrePresent(17,10));
      assertTrue(laby.getCaisse(17,9));
    }

  @Test
  public void test05_emplacementSortieCaisse() throws IOException {
        // Initialisation
      Labyrinthe laby = new Labyrinthe("labySimple/labySokoban.txt");

      //Verification de la position des sorties
      assertTrue(laby.getEmplacementsCaisse().etrePresent(6,1),"les coordonnes 6/1 devraient etre un emplacement de caisse");
      assertTrue(laby.getEmplacementsCaisse().etrePresent(17,1),"les coordonnes 17/1 devraient etre un emplacement de caisse");
      assertTrue(laby.getEmplacementsCaisse().etrePresent(13,4),"les coordonnes 13/4 devraient etre un emplacement de caisse");
      assertTrue(laby.getEmplacementsCaisse().etrePresent(18,5),"les coordonnes 18/5 devraient etre un emplacement de caisse");
      assertTrue(laby.getEmplacementsCaisse().etrePresent(4,7),"les coordonnes 4/7 devraient etre un emplacement de caisse");
      assertTrue(laby.getEmplacementsCaisse().etrePresent(10,9),"les coordonnes 10/9 devraient etre un emplacement de caisse");
  }

  @Test
  public void test06_etreFini() throws IOException {
    // Initialisation
    Labyrinthe laby = new Labyrinthe("labySimple/labySokobanTestFini.txt");
    laby.deplacerPerso("Haut");
    laby.deplacerPerso("Haut");

    //Verification
    assertTrue(laby.etreFini(), "Le labyrinthe devrait etre fini");
  }

    @Test
    public void test07_etreFini_Non() throws IOException {
        // Initialisation
        Labyrinthe laby = new Labyrinthe("labySimple/labySokobanTestFini.txt");

        //Verification
        assertFalse(laby.etreFini(), "Le labyrinthe ne devrait pas etre fini");
    }
}

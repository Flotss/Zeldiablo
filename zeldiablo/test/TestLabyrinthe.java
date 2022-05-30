
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
        laby.deplacerPerso("HAUT");
        laby.deplacerCaisse(17, 10, "HAUT");
        laby.etreFini();
        laby.caseDisponible(12, 10);

    }


    @Test
    public void constructeur() {

    }


    @Test
    public void caseDisponible() {

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
    public void deplacerPersoEtCaisse() {

    }

}

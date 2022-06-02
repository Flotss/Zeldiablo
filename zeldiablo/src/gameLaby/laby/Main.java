package gameLaby.laby;

import java.io.IOException;
import java.util.ArrayList;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> nomsFichiers = new ArrayList<String>();
        nomsFichiers.add("labySimple/labySokobanGlace.txt");
        nomsFichiers.add("labySokoban2.txt");
        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe(nomsFichiers);

        //affiche le labyrinthe charge
        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y))
                    System.out.print('X');
                else
                    System.out.print('.');
            }
            // saut de ligne
            System.out.println();
        }
    }
}

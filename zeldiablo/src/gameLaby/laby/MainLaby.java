package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {
  public static void main(String[] args) throws IOException {
    int pFPS = 20;

    // creation des objets
    LabyJeu jeuLab = new LabyJeu("labySimple/labySokobanGlace.txt");
    int width = jeuLab.getLaby().getLength()*60;
    int height = jeuLab.getLaby().getLengthY()*60;
    LabyDessin dessinLab = new LabyDessin();

    // parametrage du moteur de jeu
    MoteurJeu.setTaille(width,height);
    MoteurJeu.setFPS(pFPS);

    // lancement du jeu
    MoteurJeu.launch(jeuLab, dessinLab);
  }

}

package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {
  public static void main(String[] args) throws IOException {
    int width = 800;
    int height = 600;
    int pFPS = 20;

    // creation des objets
    LabyJeu jeuLab = new LabyJeu("labySimple/laby1.txt");
    LabyDessin dessinLab = new LabyDessin();

    // parametrage du moteur de jeu
    MoteurJeu.setTaille(width,height);
    MoteurJeu.setFPS(pFPS);

    // lancement du jeu
    MoteurJeu.launch(jeuLab, dessinLab);
  }

}
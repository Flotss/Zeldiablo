package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;
import java.util.ArrayList;

public class MainLaby {
  public static void main(String[] args) throws IOException {
    int pFPS = 10;
    ArrayList<String> nomsFichiers = new ArrayList<String>();
    nomsFichiers.add("labySimple/labySokobanGlace.txt");
    //Version 2 etages
    nomsFichiers.add("labySimple/labySokoban2.txt");

    //version 3 etages
//    nomsFichiers.add("labySimple/labySokoban2Escalier.txt");
//    nomsFichiers.add("labySimple/labySokoban3.txt");

    // creation des objets
    LabyJeu jeuLab = new LabyJeu(nomsFichiers);
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

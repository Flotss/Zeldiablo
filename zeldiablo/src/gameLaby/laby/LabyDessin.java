package gameLaby.laby;

import gameLaby.laby.utils.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.FrameStats;
import moteurJeu.Jeu;


public class LabyDessin implements DessinJeu {

    public static boolean dernierUpdateFait = false;

    /**
     * indique si les images ont ete chargees
     */
    public static boolean IMAGE_CHARGE = false;

    /**
     * image du labyrinthe
     */
    public Image imageMur;
    public Image imageCaisse;
    public Image imageGlace;
    public Image imagePersonnage;
    public Image imageSortie;
    public Image imageEscalier;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        // si les images n'ont pas ete chargees, on les charge et on indique que les images ont ete chargees
        if (!IMAGE_CHARGE) {
            this.imageMur = Sprite.MUR;
            this.imageCaisse = Sprite.CAISSE;
            this.imageGlace = Sprite.GLACE;
            this.imagePersonnage = Sprite.PERSO;
            this.imageSortie = Sprite.SORTIE;
            this.imageEscalier = Sprite.ESCALIER;
            IMAGE_CHARGE = true;
        }

        LabyJeu labyJeu = (LabyJeu) jeu;
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        if (!dernierUpdateFait) {
            gc.setFill(Color.LIGHTGRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            // dessin des emplacements de caisses
            EmplacementsCaisse emplacementCaisse = labyJeu.getLaby().getEmplacementsCaisse();
            for (int i = 0; i < emplacementCaisse.getPos().length; i++) {
                for (int j = 0; j < emplacementCaisse.getPos()[i].length; j++) {
                    if (emplacementCaisse.getPos()[i][j]) {
                        gc.setFill(Color.PINK);
                        gc.fillOval(i * 60 + 15, j * 60 + 15, 30, 30);
                    }
                }

            }

            // parcours de tous les tableaux
            for (int i = 0; i < labyJeu.getLaby().getMurs().length; i++) {
                for (int j = 0; j < labyJeu.getLaby().getMurs()[i].length; j++) {
                    // si la case est de la glace on la dessine
                    if (labyJeu.getLaby().getGlace(i, j)) {
                        gc.drawImage(imageGlace, i * 60, j * 60);
                    }
                    // si la case est un mur on dessine l'image du mur
                    if (labyJeu.getLaby().getMur(i, j)) {
                        gc.drawImage(imageMur, i * 60, j * 60);
                    }
                    // si la case est une caisse on dessine l'image de la caisse
                    if (labyJeu.getLaby().getCaisse(i, j)) {
                        gc.drawImage(imageCaisse, i * 60.5, j * 60.5);
                    }
                }
            }

            Perso perso = labyJeu.getLaby().getPj();
            //dessin du personnage
            gc.drawImage(imagePersonnage, perso.x * 60.5, perso.y * 60);
            //dessin de l'escalier si doit apparaitre
            if (labyJeu.getLaby().getEscalier() != null) {
                if (labyJeu.getLaby().getEscalierAfficher()) {
                    Escalier e = labyJeu.getLaby().getEscalier();
                    gc.drawImage(imageEscalier, e.getX() * 60, e.getY() * 60);
                }
            } else {
                if (labyJeu.getLaby().etreFini()) {
                    //Fin du jeu car tous les labyrinthes sont termines
                    dernierUpdateFait = true;
                    gc.setFill(Color.GRAY);
                    gc.fillRect(canvas.getWidth() / 2 - 150, canvas.getHeight() / 2 - 60, 300, 120);
                    gc.setFill(Color.WHITE);
                    //Affichage d'une page de fin avec le score du joueur a l'aide des frames passees
                    //(~le temps ecoule avec une incertitude de l'ordre de 3seg/minutes)
                    String fin = "Bravo! Vous avez gagné ! Avec un score de :" + FrameStats.frameCount;
                    gc.fillText(fin, canvas.getWidth() / 2 - 60, canvas.getHeight() / 2, 1000);

                }
            }
        }
    }
}



package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

public class LabyDessin implements DessinJeu {

    public static boolean dernierUpdateFait = false;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        LabyJeu labyJeu = (LabyJeu) jeu;
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        if (!dernierUpdateFait) {
            gc.setFill(Color.LIGHTGRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        ArrayList<int[]> emplacementCaisse = labyJeu.getLaby().getEmplacementsCaisse();
        for (int i = 0; i < emplacementCaisse.size(); i++) {
            gc.setFill(Color.PINK);
            gc.fillOval(emplacementCaisse.get(i)[0]*60+15, emplacementCaisse.get(i)[1]*60+15,30,30);
        }
            for (int i = 0; i < labyJeu.getLaby().murs.length; i++) {
                for (int j = 0; j < labyJeu.getLaby().murs[i].length; j++) {
                    if(labyJeu.getLaby().getGlace(i,j)){
                        gc.setFill(Color.LIGHTBLUE);
                        gc.fillRect(i * 60, j * 60, 60, 60);
                    }
                    if (labyJeu.getLaby().getMur(i, j)) {
                        gc.setFill(Color.BLACK);
                        gc.fillRect(i * 60, j * 60, 60, 60);
                    }
                    if (labyJeu.getLaby().getCaisse(i, j)) {
                        gc.setFill(Color.BROWN);
                        gc.fillRect(i * 60+5, j * 60+5, 50, 50);
                    }
                }
            }

            Perso perso = labyJeu.getLaby().pj;

            gc.setFill(Color.RED);
            gc.fillOval(perso.x * 60, perso.y * 60, 60, 60);
        }
        if(labyJeu.getLaby().etreFini()){
            dernierUpdateFait = true;
            gc.setFill(Color.GRAY);
            gc.fillRect(canvas.getWidth()/2-150,canvas.getHeight()/2-60,300,120);
            gc.setFill(Color.WHITE);
            gc.fillText("Bravo! Vous avez gagner!",canvas.getWidth()/2-60,canvas.getHeight()/2,1000);

        }
    }
}

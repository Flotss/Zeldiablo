package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;

import static gameLaby.laby.Labyrinthe.MUR;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        LabyJeu labyJeu = (LabyJeu) jeu;
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for(int i = 0 ; i < labyJeu.getLaby().murs.length ; i++){
            for(int j = 0 ; j < labyJeu.getLaby().murs[i].length ; j++){
                if(labyJeu.getLaby().getMur(i,j)){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i*60, j*60,60, 60);
                }
                if(labyJeu.getLaby().getCaisse(i,j)){
                    gc.setFill(Color.BROWN);
                    gc.fillRect(i*60, j*60,60, 60);
                }
            }
        }

        Perso perso =  labyJeu.getLaby().pj;

        gc.setFill(Color.RED);
        gc.fillOval(perso.x*60, perso.y*60, 60, 60);
    }
}

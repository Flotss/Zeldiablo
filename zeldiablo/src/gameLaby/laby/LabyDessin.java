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

        for(int i = 0 ; i < labyJeu.getLaby().murs.length ; i+=20){
            for(int j = 0 ; j < labyJeu.getLaby().murs[i].length ; j+=20){
                if(labyJeu.getLaby().getMur(i,j)){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(j*20, i*20, 20, 20);
                }
            }
        }

    }
}

package moteurJeu;

import javafx.scene.input.KeyEvent;

public class Clavier {

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite, dhaut, dbas, dgauche, ddroite, espace;

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {

        switch (event.getCode().toString()) {

            // si touche bas
            case "S":
                this.bas = true;
                break;

            // si touche haut
            case "Z":
                this.haut = true;
                break;

            // si touche gauche
            case "Q":
                this.gauche = true;
                break;

            // si touche droite
            case "D":
                this.droite = true;
                break;

            // si fleche directionelle bas
            case "DOWN":
                this.dbas = true;
                break;

            // si fleche directionelle haut
            case "UP":
                this.dhaut = true;
                break;

            // si fleche directionelle gauche
            case "LEFT":
                this.dgauche = true;
                break;

            // si fleche directionelle droite
            case "RIGHT":
                this.ddroite = true;
                break;

            // si barre espace
            case "SPACE":
                this.espace = true;
                break;
        }

    }

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void relacherTouche(KeyEvent event) {

        switch (event.getCode().toString()) {

            // si touche bas
            case "S":
                this.bas = false;
                break;

            // si touche haut
            case "Z":
                this.haut = false;
                break;

            // si touche gauche
            case "Q":
                this.gauche = false;
                break;

            // si touche droite
            case "D":
                this.droite = false;
                break;

            // si fleche directionelle bas
            case "DOWN":
                this.dbas = false;
                break;

            // si fleche directionelle haut
            case "UP":
                this.dhaut = false;
                break;

            // si fleche directionelle gauche
            case "LEFT":
                this.dgauche = false;
                break;

            // si fleche directionelle droite
            case "RIGHT":
                this.ddroite = false;
                break;

            // si barre espace
            case "SPACE":
                this.espace = false;
                break;
        }
    }
}

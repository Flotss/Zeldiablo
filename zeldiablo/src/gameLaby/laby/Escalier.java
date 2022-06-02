package gameLaby.laby;

public class Escalier {
    private int x,y;
    private boolean affiche;


    public Escalier(int x, int y) {
        this.x = x;
        this.y = y;
        this.affiche = false;
    }

    /**
     * Methode qui verifie si l'escalier est sur les coordonnees
     * @param x coordonnee x
     * @param y coordonnee y
     * @return true si l'escalier est sur les coordonnees
     */
    public boolean etrePresent(int x, int y) {
        return this.x == x && this.y == y;
    }

    /**
     * Methode qui affiche l escalier
     */
    public void afficherEscalier() {
        this.affiche = true;
    }

    /**
     * Methode qui cache l escalier
     */
    public void cacherEscalier() {
        this.affiche = false;
    }

    /**
     * Methode qui verifie si l escalier est affiche
     * @return true si l escalier est affiche
     */
    public boolean etreAffiche() {
        return this.affiche;
    }


}
